package com.example.opportunityforall.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.opportunityforall.databinding.FragmentAthlete3Binding
import com.example.opportunityforall.startActivity
import com.example.opportunityforall.ui.activities.MainActivity

class AthleteFragment3 : Fragment() {
    private var _binding: FragmentAthlete3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthlete3Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            cancelAction.setOnClickListener {
                startActivity<MainActivity>()
            }
        }
    }
}