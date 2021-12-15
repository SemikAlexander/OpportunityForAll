package com.example.opportunityforall.ui.fragments.athlete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentAthlete4Binding

class AthleteFragment4 : Fragment() {
    private var _binding: FragmentAthlete4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthlete4Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            cancelAction.setOnClickListener {
                findNavController().navigate(R.id.action_athleteFragment4_to_loginFragment)
            }

            backButton.setOnClickListener {
                findNavController().navigate(R.id.action_athleteFragment4_to_athleteFragment5)
            }

            nextButton.setOnClickListener {
                findNavController().navigate(R.id.action_athleteFragment4_to_athleteFragment5)
            }
        }
    }
}