package com.example.opportunityforall.ui.fragments.community.actions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentInfoAthleteBinding
import com.example.opportunityforall.ui.activities.MainActivity
import com.example.opportunityforall.ui.adapters.classes.Athlete
import com.google.gson.Gson

class InfoAthleteFragment : Fragment() {

    private var _binding: FragmentInfoAthleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoAthleteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainActivity.isShowBottomBar.postValue(false)

        binding.run {

            nameAthlete.text = arguments?.getString("name")
            cityAthlete.text = arguments?.getString("city")
            sportAthlete.text = arguments?.getString("sport")
            ageAthlete.text = arguments?.getInt("age").toString()
            photoAthlete.setImageResource(requireArguments().getInt("photo"))
            universityAthlete.text = arguments?.getString("university")
            yearsInSchoolAthlete.text = arguments?.getString("years")
            majorAthlete.text = arguments?.getString("majors")
            minorsAthlete.text = arguments?.getString("minors")

            cooperationRequest.setOnClickListener {
                findNavController().navigate(R.id.action_infoAthleteFragment_to_getStartedFragment)
            }

            backButton.setOnClickListener {
                findNavController().popBackStack()
                MainActivity.isShowBottomBar.postValue(true)
            }
        }
    }
}