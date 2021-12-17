package com.example.opportunityforall.ui.fragments.athlete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
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
                    action_townsAthleteFragment_to_academicSportsAthleteFragment
                )
            }
        }
    }
}