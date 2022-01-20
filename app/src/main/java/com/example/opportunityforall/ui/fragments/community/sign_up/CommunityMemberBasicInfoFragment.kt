package com.example.opportunityforall.ui.fragments.community.sign_up

import android.net.Uri
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.opportunityforall.R
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.core.FileUtil
import com.example.opportunityforall.databinding.FragmentCommunityMemberBasicInfoBinding
import com.example.opportunityforall.phoneNumberMask
import java.net.URI

class CommunityMemberBasicInfoFragment : Fragment() {

    private var _binding: FragmentCommunityMemberBasicInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var uri: Uri

    private val pickFileContract =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) {
            uri = it

            Glide.with(this)
                .load(it)
                .circleCrop()
                .into(binding.avatarIV)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommunityMemberBasicInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            phoneNumberMask(phoneNumberTV)

            hidePassword.setOnClickListener {
                visibleChange(hidePassword, passwordTV)
            }

            hideConfirmPassword.setOnClickListener {
                visibleChange(hideConfirmPassword, confirmPasswordTV)
            }

            cancelAction.setOnClickListener {
                findNavController().popBackStack(R.id.loginFragment, false)
            }

            avatarIV.setOnClickListener {
                pickFileContract.launch(arrayOf("image/*")) //mime type
            }

            nextButton.setOnClickListener {
                if (passwordTV.text.toString() == confirmPasswordTV.text.toString()) {

                    findNavController().navigate(
                        action_communityMemberBasicInfoFragment_to_communityMemberLocationFragment,
                        bundleOf(
                            "name" to nameTV.text.toString(),
                            "phoneNumber" to phoneNumberTV.text.toString(),
                            "email" to emailTV.text.toString(),
                            "password" to passwordTV.text.toString(),
                            "file" to uri
                        )
                    )
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