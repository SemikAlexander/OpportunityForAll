package com.example.opportunityforall.ui.fragments.community.actions.flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentFlow4Binding

class FlowFragment4 : Fragment() {

    private var _binding: FragmentFlow4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlow4Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            cancelAction.setOnClickListener {
                findNavController().popBackStack(R.id.infoAthleteFragment, false)
            }

            nextButton.setOnClickListener {
                findNavController().navigate(R.id.action_flowFragment4_to_flowFragment5)
            }
        }
    }
}