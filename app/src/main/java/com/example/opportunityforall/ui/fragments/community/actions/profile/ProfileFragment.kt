package com.example.opportunityforall.ui.fragments.community.actions.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentProfileBinding
import com.example.opportunityforall.ui.TypeBottomBar
import com.example.opportunityforall.ui.activities.MainActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainActivity.isShowBottomBar.postValue(false)

        binding.run {
            backButton.setOnClickListener {
                findNavController().popBackStack(athletesFragment, false)
                MainActivity.isShowBottomBar.postValue(true)
                MainActivity.typeBottomBar.postValue(TypeBottomBar.COMMUNITY)
            }

            editProfile.setOnClickListener {
                findNavController().navigate(action_profileFragment_to_editProfileFragment)
            }

            changePassword.setOnClickListener {
                findNavController().navigate(action_profileFragment_to_changePasswordFragment)
            }

            about.setOnClickListener {
                findNavController().navigate(action_profileFragment_to_aboutFragment)
            }

            editBusinessInfo.setOnClickListener {
                findNavController().navigate(action_profileFragment_to_businessInfoFragment)
            }

            logout.setOnClickListener {
                findNavController().popBackStack(loginFragment, false)
            }
        }
    }
}