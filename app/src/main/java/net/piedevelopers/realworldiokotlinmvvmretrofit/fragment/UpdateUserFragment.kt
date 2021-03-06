package net.piedevelopers.realworldiokotlinmvvmretrofit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import net.piedevelopers.realworldiokotlinmvvmretrofit.databinding.FragmentSignupBinding
import net.piedevelopers.realworldiokotlinmvvmretrofit.databinding.FragmentUpdateBinding
import net.piedevelopers.realworldiokotlinmvvmretrofit.viewModel.AuthViewModel

class UpdateUserFragment:Fragment() {

    var _binding:FragmentUpdateBinding?=null
     val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        _binding= FragmentUpdateBinding.inflate(inflater,container,false)

        return  _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel.user.observe({ lifecycle }) {
            _binding?.apply {
                bioEditText.setText(it?.bio ?: "")
                emailEditText.setText(it?.email ?: "")
                usernameEditText.setText(it?.username ?: "")
               imageEditText.setText(it?.image ?: "")
            }
        }

        _binding?.apply {
            submitButton.setOnClickListener {
                authViewModel.update(
                        bio = bioEditText.text.toString(),
                        username = usernameEditText.text.toString().takeIf { it.isNotBlank() },
                        image = imageEditText.text.toString(),
                        email = emailEditText.text.toString().takeIf { it.isNotBlank() },
                        password = passwordEditText.text.toString().takeIf { it.isNotBlank() }
                )
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        }

    }
    }


