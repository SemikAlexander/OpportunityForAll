package com.example.opportunityforall.ui.fragments.community.actions.profile.add_business

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.databinding.FragmentEditBusinessInfoBinding
import com.example.opportunityforall.zipCodeMask

class EditBusinessInfoFragment : Fragment() {

    private var _binding: FragmentEditBusinessInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBusinessInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            zipCodeMask(zipCodeBusiness)

            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            saveChanges.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}