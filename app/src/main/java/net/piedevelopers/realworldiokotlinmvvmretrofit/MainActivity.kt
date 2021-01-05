package net.piedevelopers.realworldiokotlinmvvmretrofit

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings.Secure.putString
import android.util.Log
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import net.piedevelopers.api.response.User
import net.piedevelopers.realworldiokotlinmvvmretrofit.databinding.ActivityMainBinding
import net.piedevelopers.realworldiokotlinmvvmretrofit.viewModel.AuthViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var binding:ActivityMainBinding
    lateinit var authViewModel:AuthViewModel
    companion object {
        const val PREFS_FILE_AUTH = "prefs_auth"
        const val PREFS_KEY_TOKEN = "token"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(PREFS_FILE_AUTH, Context.MODE_PRIVATE)
         authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)



        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(binding.appBarMain.toolbar)

//        val fab: FloatingActionButton = findViewById(R.id.fab)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
//        val navView: NavigationView = findViewById(R.id.nav_view
//
        val navView: NavigationView = binding.navView
        val drawerLayout: DrawerLayout =binding.drawerLayout

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_feed,
                R.id.nav_auth,
                R.id.nav_update

        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

       //  authViewModel= AuthViewModel()
        sharedPreferences.getString(PREFS_KEY_TOKEN, null)?.let { t ->
            Log.i("token",t)
            authViewModel.getCurrentUser(t)
        }
        authViewModel.user.observe({ lifecycle }) {
           updateMenu(it)
            it?.token?.let { t ->
                sharedPreferences.edit {
                    putString(PREFS_KEY_TOKEN, t)
                }
            } ?: run {
                sharedPreferences.edit {
                    remove(PREFS_KEY_TOKEN)
                }
            }
            navController.navigateUp()
        }
    }
    private fun updateMenu(user: User?) {
        when (user) {
            is User -> {
                Log.i("enter","0");
                binding.navView.menu.clear()
                binding.navView.inflateMenu(R.menu.activity_main_drawer)
            }
//            else -> {
//                Log.i("enter","1");
//                binding.navView.menu.clear()
//                binding.navView.inflateMenu(R.menu.activity_main_drawer_guest)
//            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}