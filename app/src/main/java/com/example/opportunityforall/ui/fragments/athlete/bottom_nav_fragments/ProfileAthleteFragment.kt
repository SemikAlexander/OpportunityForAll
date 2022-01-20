package com.example.opportunityforall.ui.fragments.athlete.bottom_nav_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentProfileAthleteBinding
import com.example.opportunityforall.ui.activities.MainActivity

class ProfileAthleteFragment : Fragment() {

    private var _binding: FragmentProfileAthleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileAthleteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            editProfile.setOnClickListener {
                MainActivity.isShowBottomBar.postValue(false)

                findNavController().navigate(
                    action_profileAthleteFragment_to_editBasicInformationAthleteFragment
                )
            }

            locationAthleteLayout.setOnClickListener {
                MainActivity.isShowBottomBar.postValue(false)

                findNavController().navigate(
                    action_profileAthleteFragment_to_editLocationAthleteFragment
                )
            }

            academicInfoAthlete.setOnClickListener {
                MainActivity.isShowBottomBar.postValue(false)

                findNavController().navigate(
                    action_profileAthleteFragment_to_editAcademicInfoAthleteFragment
                )
            }

            changePasswordAthlete.setOnClickListener {
                MainActivity.isShowBottomBar.postValue(false)

                findNavController().navigate(
                    action_profileAthleteFragment_to_changePasswordFragment
                )
            }

            about.setOnClickListener {
                MainActivity.isShowBottomBar.postValue(false)

                findNavController().navigate(
                    action_profileAthleteFragment_to_aboutFragment
                )
            }

            logout.setOnClickListener {
                MainActivity.isShowBottomBar.postValue(false)

                findNavController().popBackStack(loginFragment, false)
            }
        }
    }
}