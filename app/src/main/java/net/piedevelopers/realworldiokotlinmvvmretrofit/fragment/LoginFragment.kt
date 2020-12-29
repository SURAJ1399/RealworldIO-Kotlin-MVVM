package net.piedevelopers.realworldiokotlinmvvmretrofit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import net.piedevelopers.realworldiokotlinmvvmretrofit.databinding.FragmentLoginBinding
import net.piedevelopers.realworldiokotlinmvvmretrofit.viewModel.AuthViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    val authViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply {
            loginButton.setOnClickListener {
                authViewModel.login(
                        emailEditText.text.toString(),
                        passwordEditText.text.toString()
                )
            }

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}