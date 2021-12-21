package com.example.opportunityforall.ui.fragments.community.actions.profile.add_business

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.businessInfoFragment
import com.example.opportunityforall.databinding.FragmentLocationBusinessBinding

class LocationFragment : Fragment() {

    private var _binding: FragmentLocationBusinessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationBusinessBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            cancelAction.setOnClickListener {
                findNavController().popBackStack(businessInfoFragment, false)
            }

            confirmButton.setOnClickListener {
                findNavController().popBackStack(businessInfoFragment, false)
            }
        }
    }
}