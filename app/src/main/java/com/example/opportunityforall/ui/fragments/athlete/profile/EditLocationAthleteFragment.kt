package com.example.opportunityforall.ui.fragments.athlete.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentEditLocationAthleteBinding
import com.example.opportunityforall.ui.activities.MainActivity

class EditLocationAthleteFragment : Fragment() {

    private var _binding: FragmentEditLocationAthleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditLocationAthleteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            backButton.setOnClickListener {
                findNavController().popBackStack()
                MainActivity.isShowBottomBar.postValue(true)
            }

            saveChanges.setOnClickListener {
                findNavController().popBackStack(R.id.profileAthleteFragment, false)
                MainActivity.isShowBottomBar.postValue(true)
            }
        }
    }
}