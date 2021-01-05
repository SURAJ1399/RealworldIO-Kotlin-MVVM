package net.piedevelopers.realworldiokotlinmvvmretrofit.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import net.piedevelopers.api.RetrofitInterface
import net.piedevelopers.api.repo.UsersRepo
import net.piedevelopers.api.response.User
import net.piedevelopers.api.response.UserResponse
import retrofit2.Response
import javax.inject.Inject


class AuthViewModel
    :ViewModel() {
   private val _user = MutableLiveData<User?> ()
    val user:LiveData<User?> = _user




    fun login(email:String, password:String)=viewModelScope.launch {

       UsersRepo.login(email,password).let {
           _user.postValue(it)
       }

    }
    fun update(
            bio: String?,
            username: String?,
            image: String?,
            email: String?,
            password: String?
    ) = viewModelScope.launch {
        UsersRepo.updateUser(bio, username, image, email, password)?.let {
            _user.postValue(it)
        }
    }
}