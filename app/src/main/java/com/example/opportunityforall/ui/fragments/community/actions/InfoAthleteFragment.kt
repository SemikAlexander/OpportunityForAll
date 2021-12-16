package com.example.opportunityforall.ui.fragments.community.actions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentInfoAthleteBinding

class InfoAthleteFragment : Fragment() {

    private var _binding: FragmentInfoAthleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoAthleteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            cooperationRequest.setOnClickListener {
                findNavController().navigate(R.id.action_infoAthleteFragment_to_getStartedFragment)
            }

            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}