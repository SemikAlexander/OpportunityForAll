package com.example.opportunityforall.ui.fragments.community.bottom_nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.ui.TypeBottomBar.*
import com.example.opportunityforall.databinding.FragmentAthletesBinding
import com.example.opportunityforall.ui.activities.MainActivity
import com.example.opportunityforall.ui.adapters.AthleteAdapter
import com.example.opportunityforall.ui.adapters.classes.Athlete

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
            athletesAdapter.adapter = AthleteAdapter(
                athleteArray,
                onItemClick = {

                    val bundle = Bundle()
                    bundle.putString("name", it.nameAthlete)
                    bundle.putString("city", it.cityAthlete)
                    bundle.putString("sport", it.sportAthlete)
                    bundle.putInt("age", it.ageAthlete)
                    bundle.putInt("photo", it.photoAthlete)
                    bundle.putString("university", it.universityAthlete)
                    bundle.putString("years", it.yearsInSchoolAthlete)
                    bundle.putString("majors", it.majorsAthlete)
                    bundle.putString("minors", it.minorsAthlete)

                    findNavController()
                        .navigate(action_athletesFragment_to_infoAthleteFragment, bundle)
                }
            )

            filter.setOnClickListener {
                findNavController().navigate(action_athletesFragment_to_filterFragment)
                //findNavController().navigate(action_athletesFragment_to_infoAthleteFragment) //test!!!
            }

            avatarUser.setOnClickListener {
                findNavController().navigate(action_athletesFragment_to_profileFragment)
            }
        }
    }

    private val athleteArray = arrayListOf(
        Athlete(
            nameAthlete = "Davis Lipshutz",
            cityAthlete = "Saint Paul, Minnesota",
            sportAthlete = "Baseball",
            photoAthlete = R.drawable.photo,
            ageAthlete = 25,
            universityAthlete = "Kansas State University",
            yearsInSchoolAthlete = "Senior",
            majorsAthlete = "not specified",
            minorsAthlete = "not specified"
        ),
        Athlete(
            nameAthlete = "David Lourenc",
            cityAthlete = "Saint Paul, Minnesota",
            sportAthlete = "Football",
            photoAthlete = R.drawable.photo3,
            ageAthlete = 21,
            universityAthlete = "Kansas State University",
            yearsInSchoolAthlete = "Senior",
            majorsAthlete = "not specified",
            minorsAthlete = "not specified"
        ),
        Athlete(
            nameAthlete = "Albert Piastri",
            cityAthlete = "Saint Paul, Minnesota",
            sportAthlete = "Football",
            photoAthlete = R.drawable.photo,
            ageAthlete = 23,
            universityAthlete = "Kansas State University",
            yearsInSchoolAthlete = "Senior",
            majorsAthlete = "not specified",
            minorsAthlete = "not specified"
        ),
        Athlete(
            nameAthlete = "John Docker",
            cityAthlete = "Saint Paul, Minnesota",
            sportAthlete = "Basketball",
            photoAthlete = R.drawable.photo3,
            ageAthlete = 20,
            universityAthlete = "Kansas State University",
            yearsInSchoolAthlete = "Senior",
            majorsAthlete = "not specified",
            minorsAthlete = "not specified"
        ),
        Athlete(
            nameAthlete = "George Rust",
            cityAthlete = "Saint Paul, Minnesota",
            sportAthlete = "Football",
            photoAthlete = R.drawable.photo3,
            ageAthlete = 23,
            universityAthlete = "Kansas State University",
            yearsInSchoolAthlete = "Senior",
            majorsAthlete = "not specified",
            minorsAthlete = "not specified"
        ),
        Athlete(
            nameAthlete = "Bill Docker",
            cityAthlete = "Saint Paul, Minnesota",
            sportAthlete = "Basketball",
            photoAthlete = R.drawable.photo,
            ageAthlete = 25,
            universityAthlete = "Kansas State University",
            yearsInSchoolAthlete = "Senior",
            majorsAthlete = "not specified",
            minorsAthlete = "not specified"
        )
    )
}