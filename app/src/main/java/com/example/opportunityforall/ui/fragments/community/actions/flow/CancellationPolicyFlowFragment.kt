package com.example.opportunityforall.ui.fragments.community.actions.flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentFlowCancellationPolicyBinding

class CancellationPolicyFlowFragment : Fragment() {

    private var _binding: FragmentFlowCancellationPolicyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlowCancellationPolicyBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            val radioButtons = listOf(
                flexibleCancellationPolicy, mediumCancellationPolicy, strictCancellationPolicy
            )

            val descriptions = listOf(
                flexibleCancellationPolicyDescription,
                mediumCancellationPolicyDescription,
                strictCancellationPolicyDescription
            )

            cancelAction.setOnClickListener {
                findNavController().popBackStack(R.id.infoAthleteFragment, false)
            }

            nextButton.setOnClickListener {
                findNavController().navigate(R.id.action_cancellationPolicyFlowFragment_to_requestFragmentCommunity)
            }

            radioButtons.indices.forEach { i ->
                radioButtons[i].setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        radioButtons.forEach { it.isChecked = false }
                        descriptions.forEach { it.visibility = View.GONE }

                        radioButtons[i].isChecked = true
                        descriptions[i].visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}