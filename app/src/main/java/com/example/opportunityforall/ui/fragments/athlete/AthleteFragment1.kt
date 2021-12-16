package com.example.opportunityforall.ui.fragments.athlete

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentAthlete1Binding

class AthleteFragment1 : Fragment() {
    private var _binding: FragmentAthlete1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthlete1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            hidePassword.setOnClickListener {
                visibleChange(hidePassword, password)
            }

            hideConfirmPassword.setOnClickListener {
                visibleChange(hideConfirmPassword, confirmPassword)
            }

            cancelAction.setOnClickListener {
                findNavController().popBackStack(R.id.loginFragment, false)
            }

            nextButton.setOnClickListener {
                findNavController().navigate(R.id.action_athleteFragment1_to_athleteFragment2)
            }
        }
    }

    private fun visibleChange(imageView: ImageView, editText: EditText) {
        binding.run {
            if (imageView.tag == "hide") {
                editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                imageView.tag = "show"
            }
            else {
                editText.transformationMethod = PasswordTransformationMethod.getInstance()
                imageView.tag = "hide"
            }
        }
    }
}