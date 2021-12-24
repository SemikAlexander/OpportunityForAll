package com.example.opportunityforall.ui.fragments.community.actions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.databinding.FragmentProposalBinding
import com.example.opportunityforall.ui.activities.MainActivity

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
            MainActivity.isShowBottomBar.postValue(false)
            athleteName.text = arguments?.getString("name")

            athletePhoto.setImageResource(requireArguments().getInt("photo"))

            finalizeContract.setOnClickListener {
                finalizeContract.visibility = View.GONE
                editProposal.visibility = View.INVISIBLE
                waitingForDecision.visibility = View.VISIBLE
            }

            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}