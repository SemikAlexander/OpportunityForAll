package com.example.opportunityforall.ui.fragments.community.actions.flow

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentFlowDateEventBinding

class DateEventFlowFragment : Fragment() {

    private var _binding: FragmentFlowDateEventBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlowDateEventBinding.inflate(layoutInflater)
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
                findNavController().navigate(R.id.action_dateEventFlowFragment_to_locationEventFlowFragment)
            }

            duration.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                @SuppressLint("SetTextI18n")
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    when (p1) {
                        1 -> durationText.text = "$p1 hour"
                        else -> durationText.text = "$p1 hours"
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {  }

                override fun onStopTrackingTouch(p0: SeekBar?) {  }
            })
        }
    }
}