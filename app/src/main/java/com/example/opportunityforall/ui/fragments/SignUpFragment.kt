package com.example.opportunityforall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.opportunityforall.R.drawable.*
import com.example.opportunityforall.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            studentAthlete.setOnClickListener {
                choiceType(studentAthlete, community)
            }

            community.setOnClickListener {
                choiceType(community, studentAthlete)
            }
        }
    }

    private fun choiceType(linear1: LinearLayout, linear2: LinearLayout) {
        linear1.background =
            ContextCompat.getDrawable(requireContext(), rounding_choise_active)

        linear2.background =
            ContextCompat.getDrawable(requireContext(), rounding_choise_default)

        binding.nextButton.isEnabled = true
    }
}