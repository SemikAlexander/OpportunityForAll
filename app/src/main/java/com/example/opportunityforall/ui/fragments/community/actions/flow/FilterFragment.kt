package com.example.opportunityforall.ui.fragments.community.actions.flow

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.drawable.rounding_choice_default
import com.example.opportunityforall.R.drawable.rounding_edit_text
import com.example.opportunityforall.databinding.FragmentFilterBinding

class FilterFragment : Fragment() {

    private var _binding: FragmentFilterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilterBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            close.setOnClickListener {
                findNavController().popBackStack()
            }

            sportConstraintLayout.setOnClickListener {
                showSportTypeMenu(true)
            }

            done.setOnClickListener {
                showSportTypeMenu(false)
            }

            clear.setOnClickListener {
                universityEditText.text.clear()
                universityEditText.clearFocus()

                showSportTypeMenu(false)
            }

            applyButton.setOnClickListener {
                findNavController().popBackStack(R.id.athletesFragment, false)
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun showSportTypeMenu(show: Boolean) {
        binding.run {
            when {
                show -> {
                    sportConstraintLayout.background =
                        resources.getDrawable(rounding_choice_default)

                    universityEditText.clearFocus()
                    sportType.visibility = View.VISIBLE
                    applyLinearLayout.visibility = View.INVISIBLE
                }
                else -> {
                    sportConstraintLayout.background =
                        resources.getDrawable(rounding_edit_text)

                    sportType.visibility = View.INVISIBLE
                    applyLinearLayout.visibility = View.VISIBLE
                }
            }
        }
    }
}