package com.example.opportunityforall.ui.fragments.athlete.sign_up

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentAthleteBasicInfoBinding

class BasicInfoAthleteFragment : Fragment() {
    private var _binding: FragmentAthleteBasicInfoBinding? = null
    private val binding get() = _binding!!

    private var uri: Uri? = null

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
        _binding = FragmentAthleteBasicInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            cancelAction.setOnClickListener {
                findNavController().popBackStack(loginFragment, false)
            }

            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            avatarIV.setOnClickListener {
                pickFileContract.launch(arrayOf("image/*"))
            }

            nextButton.setOnClickListener {
                if (uri == null) {
                    findNavController().navigate(
                        action_basicInfoAthleteFragment_to_townsAthleteFragment,
                        bundleOf(
                            "email" to arguments?.get("email").toString(),
                            "password" to arguments?.get("password").toString(),
                            "firstName" to firstNameTV.text.toString(),
                            "lastName" to lastNameTV.text.toString(),
                            "age" to ageTV.text.toString(),
                            "file" to ""
                        )
                    )
                } else {
                    findNavController().navigate(
                        action_basicInfoAthleteFragment_to_townsAthleteFragment,
                        bundleOf(
                            "email" to arguments?.get("email").toString(),
                            "password" to arguments?.get("password").toString(),
                            "firstName" to firstNameTV.text.toString(),
                            "lastName" to lastNameTV.text.toString(),
                            "age" to ageTV.text.toString(),
                            "file" to uri
                        )
                    )
                }
            }
        }
    }
}