package com.example.opportunityforall.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.opportunityforall.databinding.AthletesRecycleViewBinding
import com.example.opportunityforall.databinding.ChatsRecycleViewBinding
import com.example.opportunityforall.ui.adapters.classes.Chats

class ChatsListAdapter (
    private val values: ArrayList<Chats>,
    private val onItemClick: (Chats) -> Unit
) : RecyclerView.Adapter<ChatsListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsListAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(
            ChatsRecycleViewBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatsListAdapter.MyViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount() = values.size

    inner class MyViewHolder(
        private val binding: ChatsRecycleViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Chats) = binding.run {
            chatItemView.setOnClickListener { onItemClick.invoke(item) }

            photoUser.setImageResource(item.photo)
            nameUser.text = item.name
            textMessage.text = item.textMessage
        }
    }
}