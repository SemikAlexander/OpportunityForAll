package com.example.opportunityforall.ui.fragments.community.bottom_nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.ui.TypeBottomBar.*
import com.example.opportunityforall.databinding.FragmentAthletesBinding
import com.example.opportunityforall.ui.activities.MainActivity

class AthletesFragment : Fragment() {

    private var _binding: FragmentAthletesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthletesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainActivity.isShowBottomBar.postValue(true)
        MainActivity.typeBottomBar.postValue(COMMUNITY)

        binding.run {
            filter.setOnClickListener {
                findNavController().navigate(R.id.action_athletesFragment_to_filterFragment)
                //findNavController().navigate(R.id.action_athletesFragment_to_infoAthleteFragment) //test!!!
            }

            avatarUser.setOnClickListener {
                findNavController().navigate(R.id.action_athletesFragment_to_profileFragment)
            }
        }
    }
}