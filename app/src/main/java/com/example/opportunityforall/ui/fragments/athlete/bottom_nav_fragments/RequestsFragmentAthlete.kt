package com.example.opportunityforall.ui.fragments.athlete.bottom_nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.ui.TypeBottomBar.*
import com.example.opportunityforall.ui.activities.MainActivity
import com.example.opportunityforall.databinding.FragmentRequestsAthleteBinding
import com.example.opportunityforall.ui.adapters.RequestAdapter
import com.example.opportunityforall.ui.adapters.RequestsAthleteAdapter
import com.example.opportunityforall.ui.adapters.classes.Requests
import com.example.opportunityforall.ui.adapters.classes.RequestsAthlete

class RequestsFragmentAthlete : Fragment() {

    private var _binding: FragmentRequestsAthleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRequestsAthleteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            requestsAthleteAdapter.adapter = RequestsAthleteAdapter(
                requestArray,
                onItemClick = {
                    val bundle = Bundle()

                    findNavController()
                        .navigate(action_requestsFragmentAthlete_to_athleteProposalFragment, bundle)
                }
            )
        }
    }

    private val requestArray = arrayListOf(
        RequestsAthlete(
            image = R.drawable.wpf_signature,
            status = "New",
            date = "16 Jun 2021",
            type = "Brand Ambassador - Traditional Media",
            name = "Davis Lipshutz",
            photo = R.drawable.photo3,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ultrices morbi placerat cras..."
        ),
        RequestsAthlete(
            image = R.drawable.wpf_signature,
            status = "New",
            date = "16 Jun 2021",
            type = "Brand Ambassador - Traditional Media",
            name = "Randy Vetrovs",
            photo = R.drawable.photo,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ultrices morbi placerat cras..."
        ),
        RequestsAthlete(
            image = R.drawable.wpf_signature,
            status = "New",
            date = "16 Jun 2021",
            type = "Brand Ambassador - Traditional Media",
            name = "Randy Vetrovs",
            photo = R.drawable.photo3,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ultrices morbi placerat cras..."
        ),
        RequestsAthlete(
            image = R.drawable.wpf_signature,
            status = "New",
            date = "16 Jun 2021",
            type = "Brand Ambassador - Traditional Media",
            name = "Randy Vetrovs",
            photo = R.drawable.photo,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ultrices morbi placerat cras..."
        ),
        RequestsAthlete(
            image = R.drawable.wpf_signature,
            status = "New",
            date = "16 Jun 2021",
            type = "Brand Ambassador - Traditional Media",
            name = "Randy Vetrovs",
            photo = R.drawable.photo3,
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ultrices morbi placerat cras..."
        )
    )
}