package com.example.opportunityforall.ui.fragments.athlete.sign_up

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentAthleteEmailBinding
import com.example.opportunityforall.toast

class EmailAthleteFragment : Fragment() {
    private var _binding: FragmentAthleteEmailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthleteEmailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            hidePassword.setOnClickListener {
                visibleChange(hidePassword, passwordTV)
            }

            hideConfirmPassword.setOnClickListener {
                visibleChange(hideConfirmPassword, confirmPasswordTV)
            }

            cancelAction.setOnClickListener {
                findNavController().popBackStack(loginFragment, false)
            }

            nextButton.setOnClickListener {
                if (passwordTV.text.toString() == confirmPasswordTV.text.toString()) {

                    findNavController().navigate(
                        action_emailAthleteFragment_to_basicInfoAthleteFragment,
                        bundleOf(
                            "email" to emailTV.text.toString(),
                            "password" to passwordTV.text.toString()
                        )
                    )
                } else {
                    toast("Passwords must match!")
                }
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