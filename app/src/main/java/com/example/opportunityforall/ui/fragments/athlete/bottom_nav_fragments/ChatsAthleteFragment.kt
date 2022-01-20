package com.example.opportunityforall.ui.fragments.athlete.bottom_nav_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.opportunityforall.R
import com.example.opportunityforall.databinding.FragmentChatsAthleteBinding
import com.example.opportunityforall.ui.adapters.ChatsListAdapter
import com.example.opportunityforall.ui.adapters.classes.Chats

class ChatsAthleteFragment : Fragment() {

    private var _binding: FragmentChatsAthleteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsAthleteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            chatAthleteAdapter.adapter = ChatsListAdapter(
                chatsArray,
                onItemClick = {
                    val bundle = Bundle()

                    bundle.putString("name", it.name)
                    bundle.putString("text", it.textMessage)
                    bundle.putInt("photo", it.photo)

                    findNavController()
                        .navigate(R.id.action_chatsAthleteFragment_to_chatFragment2, bundle)
                }
            )
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