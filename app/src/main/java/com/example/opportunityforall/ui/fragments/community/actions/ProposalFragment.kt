package com.example.opportunityforall.ui.fragments.community.actions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.opportunityforall.databinding.FragmentProposalBinding

class ProposalFragment : Fragment() {

    private var _binding: FragmentProposalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProposalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            finalizeContract.setOnClickListener {
                finalizeContract.visibility = View.GONE
                waitingForDecision.visibility = View.VISIBLE
            }
        }
    }
}