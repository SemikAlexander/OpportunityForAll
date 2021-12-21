package com.example.opportunityforall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentLoginBinding
import com.example.opportunityforall.ui.activities.MainActivity

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainActivity.isShowBottomBar.postValue(false)

        binding.run {
            signUpButton.setOnClickListener {
                findNavController().navigate(action_loginFragment_to_signUpFragment)
            }

            login.setOnClickListener {
                findNavController().navigate(action_loginFragment_to_athletesFragment)
                //findNavController().navigate(action_loginFragment_to_athlete_navigation)
            }
        }
    }
}