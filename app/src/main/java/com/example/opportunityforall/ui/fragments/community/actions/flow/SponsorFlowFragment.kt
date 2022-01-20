package com.example.opportunityforall.ui.fragments.community.actions.flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColorStateList
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentFlowSponsorBinding

class SponsorFlowFragment : Fragment() {

    private var _binding: FragmentFlowSponsorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlowSponsorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            cancelAction.setOnClickListener {
                findNavController().popBackStack(infoAthleteFragment, false)
            }

            nextButton.setOnClickListener {
                findNavController().navigate(
                    action_sponsorFlowFragment_to_cancellationPolicyFlowFragment
                )
            }

            /*allowPromotionalActivities.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    allowPromotionalActivities.buttonDrawable = getColorStateList(requireContext(), R.color.check_box_active)
                } else {
                    allowPromotionalActivities.buttonTintList = getColorStateList(requireContext(), R.color.check_box_unactive)
                }
            }*/
        }
    }
}