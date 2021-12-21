package com.example.opportunityforall.ui.fragments.community.bottom_nav_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R.id.action_chatsFragment_to_profileFragment
import com.example.opportunityforall.databinding.FragmentChatsBinding
import com.example.opportunityforall.ui.activities.MainActivity

class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainActivity.isShowBottomBar.postValue(true)

        binding.run {
            avatarUser.setOnClickListener {
                findNavController().navigate(action_chatsFragment_to_profileFragment)
            }
        }
    }
}