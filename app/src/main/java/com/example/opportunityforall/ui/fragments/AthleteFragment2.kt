package com.example.opportunityforall.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.opportunityforall.databinding.FragmentAthlete2Binding

class AthleteFragment2 : Fragment() {
    private var _binding: FragmentAthlete2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthlete2Binding.inflate(layoutInflater)
        return binding.root
    }
}