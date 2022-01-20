package com.example.opportunityforall.ui.fragments.community.actions.flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentEngagementTypeFlowBinding
import org.w3c.dom.Text

class EngagementTypeFlowFragment : Fragment() {

    private var _binding: FragmentEngagementTypeFlowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEngagementTypeFlowBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            val radioButtons = listOf(
                meetAndGreet, autograph, lesson, brandAmbassadorSm, brandAmbassadorTm
            )

            val descriptions = listOf(
                meetAndGreetDescription, autographDescription,
                lessonDescription, brandAmbassadorSmDescription,
                brandAmbassadorTmDescription
            )

            cancelAction.setOnClickListener {
                findNavController().popBackStack(infoAthleteFragment, false)
            }

            nextButton.setOnClickListener {
                findNavController().navigate(
                    action_engagementTypeFlowFragment_to_describeFlowFragment
                )
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