package com.example.opportunityforall.ui.fragments.athlete.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.academicYearInSchool
import com.example.opportunityforall.databinding.FragmentAthleteAcademicSportsInfoBinding
import com.example.opportunityforall.showBottomSheetDialog
import com.example.opportunityforall.sportsList

class AcademicSportsAthleteFragment : Fragment() {
    private var _binding: FragmentAthleteAcademicSportsInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthleteAcademicSportsInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            val academicYearInSchoolViews = listOf(
                academicYearInSchoolET,
                academicYearInSchoolCL,
                openSpinAcademicYearInSchool
            )

            val sportViews = listOf(
                sportCL,
                sportET,
                openSpinSport
            )

            cancelAction.setOnClickListener {
                findNavController().popBackStack(loginFragment, false)
            }

            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            academicYearInSchoolViews.indices.forEach { i ->
                academicYearInSchoolViews[i].setOnClickListener {
                    openAcademicYearBottomSheetsDialog()
                }
            }

            sportViews.indices.forEach { i ->
                sportViews[i].setOnClickListener {
                    openSportBottomSheetsDialog()
                }
            }

            nextButton.setOnClickListener {
                findNavController().navigate(
                    action_academicSportsAthleteFragment_to_verificationAthleteFragment,
                    bundleOf(
                        "email" to arguments?.get("email").toString(),
                        "password" to arguments?.get("password").toString(),
                        "firstName" to arguments?.get("firstName").toString(),
                        "lastName" to arguments?.get("lastName").toString(),
                        "age" to arguments?.get("age").toString(),
                        "homeState" to arguments?.get("homeState").toString(),
                        "homeCity" to arguments?.get("homeCity").toString(),
                        "collegeState" to arguments?.get("collegeState").toString(),
                        "collegeCity" to arguments?.get("collegeCity").toString(),
                        "file" to arguments?.getString("file").toString(),
                        "university" to universityET.text.toString(),
                        "academicYear" to academicYearInSchoolET.text.toString(),
                        "sport" to sportET.text.toString()
                    )
                )
            }
        }
    }

    private fun openAcademicYearBottomSheetsDialog() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)

        showBottomSheetDialog(
            requireContext(),
            view,
            binding.academicYearInSchoolET,
            academicYearInSchool
        )
    }

    private fun openSportBottomSheetsDialog() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)

        showBottomSheetDialog(
            requireContext(),
            view,
            binding.sportET,
            sportsList
        )
    }
}