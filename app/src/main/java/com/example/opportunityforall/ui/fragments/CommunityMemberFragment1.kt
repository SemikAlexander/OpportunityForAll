package com.example.opportunityforall.ui.fragments

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.opportunityforall.databinding.FragmentCommunityMember1Binding

class CommunityMemberFragment1 : Fragment() {

    private var _binding: FragmentCommunityMember1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommunityMember1Binding.inflate(layoutInflater)
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
                imageView.tag = "show"
            }
        }
    }
}