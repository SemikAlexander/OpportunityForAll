package com.example.opportunityforall.ui.fragments.community.bottom_nav_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.R.id.action_chatsFragment_to_profileFragment
import com.example.opportunityforall.databinding.FragmentChatsBinding
import com.example.opportunityforall.ui.activities.MainActivity
import com.example.opportunityforall.ui.adapters.ChatsListAdapter
import com.example.opportunityforall.ui.adapters.classes.Chats

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
            chatsAdapter.adapter = ChatsListAdapter(
                chatsArray,
                onItemClick = {
                    val bundle = Bundle()

                    bundle.putString("name", it.name)
                    bundle.putString("text", it.textMessage)
                    bundle.putInt("photo", it.photo)

                    findNavController()
                        .navigate(R.id.action_chatsFragment_to_chatFragment, bundle)
                }
            )

            avatarUser.setOnClickListener {
                findNavController().navigate(action_chatsFragment_to_profileFragment)
            }
        }
    }

    private val chatsArray = arrayListOf(
        Chats(
            photo = R.drawable.photo,
            name = "Davis Lipshutz",
            textMessage = "Lorem ipsum dolor sit amet..."
        ),
        Chats(
            photo = R.drawable.photo3,
            name = "Davis Lipshutz",
            textMessage = "Lorem ipsum dolor sit amet..."
        ),
        Chats(
            photo = R.drawable.photo,
            name = "Davis Lipshutz",
            textMessage = "Lorem ipsum dolor sit amet..."
        ),
        Chats(
            photo = R.drawable.photo3,
            name = "Davis Lipshutz",
            textMessage = "Lorem ipsum dolor sit amet..."
        ),
        Chats(
            photo = R.drawable.photo,
            name = "Davis Lipshutz",
            textMessage = "Lorem ipsum dolor sit amet..."
        ),
        Chats(
            photo = R.drawable.photo3,
            name = "Davis Lipshutz",
            textMessage = "Lorem ipsum dolor sit amet..."
        ),
        Chats(
            photo = R.drawable.photo,
            name = "Davis Lipshutz",
            textMessage = "Lorem ipsum dolor sit amet..."
        ),
        Chats(
            photo = R.drawable.photo3,
            name = "Davis Lipshutz",
            textMessage = "Lorem ipsum dolor sit amet..."
        ),
    )
}