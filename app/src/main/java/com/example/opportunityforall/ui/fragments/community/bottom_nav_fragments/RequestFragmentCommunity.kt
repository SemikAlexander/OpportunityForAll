package com.example.opportunityforall.ui.fragments.community.bottom_nav_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.id.action_requestFragmentCommunity_to_profileFragment
import com.example.opportunityforall.databinding.FragmentRequestCommunityBinding
import com.example.opportunityforall.ui.adapters.RequestAdapter
import com.example.opportunityforall.ui.adapters.classes.Requests

class RequestFragmentCommunity : Fragment() {

    private var _binding: FragmentRequestCommunityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRequestCommunityBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            requestAdapter.adapter = RequestAdapter(
                requestArray,
                onItemClick = {
                    val bundle = Bundle()

                    bundle.putString("name", it.name)
                    bundle.putString("status", it.status)
                    bundle.putInt("photo", it.photo)

                    findNavController()
                        .navigate(R.id.action_requestFragmentCommunity_to_proposalFragment, bundle)
                }

            )

            avatarUser.setOnClickListener {
                findNavController().navigate(action_requestFragmentCommunity_to_profileFragment)
            }
        }
    }

    private val requestArray = arrayListOf(
        Requests(
            name = "Davis Lipshutz",
            status = "Submitted",
            photo = R.drawable.photo,
            statusImage = R.drawable.ic_sign_contract
        ),
        Requests(
            name = "Davis Lipshutz",
            status = "Submitted",
            photo = R.drawable.photo3,
            statusImage = R.drawable.ic_sign_contract
        ),
        Requests(
            name = "Davis Lipshutz",
            status = "Submitted",
            photo = R.drawable.photo,
            statusImage = R.drawable.ic_sign_contract
        ),
        Requests(
            name = "Davis Lipshutz",
            status = "Submitted",
            photo = R.drawable.photo3,
            statusImage = R.drawable.ic_sign_contract
        ),
        Requests(
            name = "Davis Lipshutz",
            status = "Submitted",
            photo = R.drawable.photo3,
            statusImage = R.drawable.ic_sign_contract
        ),
        Requests(
            name = "Davis Lipshutz",
            status = "Submitted",
            photo = R.drawable.photo,
            statusImage = R.drawable.ic_sign_contract
        ),
        Requests(
            name = "Davis Lipshutz",
            status = "Submitted",
            photo = R.drawable.photo3,
            statusImage = R.drawable.ic_sign_contract
        ),
        Requests(
            name = "Davis Lipshutz",
            status = "Submitted",
            photo = R.drawable.photo,
            statusImage = R.drawable.ic_sign_contract
        ),
    )
}