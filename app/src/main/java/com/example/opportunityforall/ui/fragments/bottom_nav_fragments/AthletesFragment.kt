package com.example.opportunityforall.ui.fragments.bottom_nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentHelloBinding

class AthletesFragment : Fragment() {

    private var _binding: FragmentHelloBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelloBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            filter.setOnClickListener {
                findNavController().navigate(R.id.action_helloFragment_to_infoAthleteFragment) //test!!!
            }
        }
    }
}