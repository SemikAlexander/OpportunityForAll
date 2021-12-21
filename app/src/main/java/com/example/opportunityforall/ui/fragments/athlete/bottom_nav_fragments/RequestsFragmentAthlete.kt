package com.example.opportunityforall.ui.fragments.athlete.bottom_nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.opportunityforall.ui.activities.MainActivity
import com.example.opportunityforall.databinding.FragmentRequestsAthleteBinding

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

        MainActivity.isShowBottomBar.postValue(true)
        MainActivity.typeBottomBar.postValue("Student-athlete")

        binding.run {

        }
    }
}