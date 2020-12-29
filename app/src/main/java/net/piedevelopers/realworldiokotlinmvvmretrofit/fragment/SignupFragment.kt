package net.piedevelopers.realworldiokotlinmvvmretrofit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.piedevelopers.realworldiokotlinmvvmretrofit.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {
    private var _binding: FragmentSignupBinding?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
          _binding= FragmentSignupBinding.inflate(inflater,container,false)

        return  _binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}