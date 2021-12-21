package com.example.opportunityforall.ui.fragments.community.actions.flow

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.drawable.rounding_choice_default
import com.example.opportunityforall.R.drawable.rounding_edit_text
import com.example.opportunityforall.databinding.FragmentFilterBinding
import com.example.opportunityforall.showBottomSheetDialog
import com.example.opportunityforall.ui.activities.MainActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class FilterFragment : Fragment() {

    private var _binding: FragmentFilterBinding? = null
    private val binding get() = _binding!!

    private var sport: String = ""

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

        MainActivity.isShowBottomBar.postValue(false)

        binding.run {
            close.setOnClickListener {
                findNavController().popBackStack()
            }

            sportConstraintLayout.setOnClickListener {
                val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)

                //Test values!!!
                showBottomSheetDialog(requireContext(), view, sportEditText, listOf("Basketball", "Bowing", "Cross country", "Fencing", "Field hockey", "Football", "Golf", "Gymnastics", "Ice hockey"))

                clear.setOnClickListener {
                    universityEditText.text.clear()
                    sportEditText.text.clear()
                    sportEditText.clearFocus()
                    universityEditText.clearFocus()
                }

                applyButton.setOnClickListener {
                    findNavController().popBackStack(R.id.athletesFragment, false)
                }
            }
        }

    }
}