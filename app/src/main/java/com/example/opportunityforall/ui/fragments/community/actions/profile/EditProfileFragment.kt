package com.example.opportunityforall.ui.fragments.community.actions.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.*
import com.example.opportunityforall.databinding.FragmentEditProfileBinding
import com.example.opportunityforall.phoneNumberMask
import ru.tinkoff.decoro.MaskImpl

import ru.tinkoff.decoro.watchers.MaskFormatWatcher

import ru.tinkoff.decoro.watchers.FormatWatcher

import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser

import ru.tinkoff.decoro.slots.Slot




class EditProfileFragment : Fragment() {

    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            phoneNumberMask(phoneNumberUser)

            saveChanges.setOnClickListener {
                findNavController().popBackStack(profileFragment, false)
            }

            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}