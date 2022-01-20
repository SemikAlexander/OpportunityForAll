package com.example.opportunityforall.ui.fragments.athlete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentAthleteProposalBinding
import com.example.opportunityforall.ui.activities.MainActivity

class AthleteProposalFragment : Fragment() {

    private var _binding: FragmentAthleteProposalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthleteProposalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            MainActivity.isShowBottomBar.postValue(false)

            backButton.setOnClickListener {
                findNavController().popBackStack()
                MainActivity.isShowBottomBar.postValue(true)
            }

            declineButton.setOnClickListener {
                findNavController().popBackStack(R.id.requestsFragmentAthlete, false)
                MainActivity.isShowBottomBar.postValue(true)
            }

            acceptButton.setOnClickListener {
                waitingForDecision.visibility = View.VISIBLE
                athleteDesigion.visibility = View.GONE
            }
        }
    }
}