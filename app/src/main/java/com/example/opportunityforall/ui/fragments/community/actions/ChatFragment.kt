package com.example.opportunityforall.ui.fragments.community.actions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.drawable.rounding_choice_default
import com.example.opportunityforall.R.drawable.rounding_edit_text
import com.example.opportunityforall.databinding.FragmentChatBinding
import com.example.opportunityforall.databinding.FragmentFilterBinding
import com.example.opportunityforall.ui.activities.MainActivity

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainActivity.isShowBottomBar.postValue(false)

        binding.run {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            contributorAvatar.setOnClickListener {

            }
        }
    }
}