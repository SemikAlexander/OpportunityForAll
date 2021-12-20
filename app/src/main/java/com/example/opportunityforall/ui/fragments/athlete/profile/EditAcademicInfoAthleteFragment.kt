package com.example.opportunityforall.ui.fragments.athlete.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.databinding.FragmentEditAcademicInfoAthleteBinding

class EditAcademicInfoAthleteFragment : Fragment() {

    private var _binding: FragmentEditAcademicInfoAthleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditAcademicInfoAthleteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            saveChanges.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}