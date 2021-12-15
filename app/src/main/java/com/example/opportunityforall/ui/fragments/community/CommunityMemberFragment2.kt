package com.example.opportunityforall.ui.fragments.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentCommunityMember2Binding

class CommunityMemberFragment2 : Fragment() {

    private var _binding: FragmentCommunityMember2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommunityMember2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            cancelAction.setOnClickListener {
                findNavController().navigate(action_communityMemberFragment2_to_loginFragment)
            }

            registerButton.setOnClickListener {
                findNavController().navigate(
                    action_athleteFragment2_to_loginFragment
                )
            }
        }
    }
}