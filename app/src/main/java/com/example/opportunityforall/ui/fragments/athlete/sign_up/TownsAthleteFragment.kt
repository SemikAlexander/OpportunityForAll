package com.example.opportunityforall.ui.fragments.athlete.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentAthleteTownsBinding

class TownsAthleteFragment : Fragment() {
    private var _binding: FragmentAthleteTownsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthleteTownsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            cancelAction.setOnClickListener {
                findNavController().popBackStack(loginFragment, false)
            }

            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            nextButton.setOnClickListener {
                findNavController().navigate(
                    action_townsAthleteFragment_to_academicSportsAthleteFragment,
                    bundleOf(
                        "email" to arguments?.get("email").toString(),
                        "password" to arguments?.get("password").toString(),
                        "firstName" to arguments?.get("firstName").toString(),
                        "lastName" to arguments?.get("lastName").toString(),
                        "age" to arguments?.get("age").toString(),
                        "file" to arguments?.getString("file").toString(),
                        "homeState" to homeStateET.text.toString(),
                        "homeCity" to homeCityET.text.toString(),
                        "collegeState" to collageStateET.text.toString(),
                        "collegeCity" to collageCityET.text.toString()
                    )
                )
            }
        }
    }
}