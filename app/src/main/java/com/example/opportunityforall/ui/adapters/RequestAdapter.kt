package com.example.opportunityforall.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.opportunityforall.databinding.CommunityRequestsRecycleViewBinding
import com.example.opportunityforall.ui.adapters.classes.Requests

class RequestAdapter (
    private val values: ArrayList<Requests>,
    private val onItemClick: (Requests) -> Unit
) : RecyclerView.Adapter<RequestAdapter.MyViewHolder>()  {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(
            CommunityRequestsRecycleViewBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(values[position])
    }

    inner class MyViewHolder(
        private val binding: CommunityRequestsRecycleViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Requests) = binding.run {
            requestItemView.setOnClickListener { onItemClick.invoke(item) }

            nameUser.text = item.name
            status.text = item.status
            photoUser.setImageResource(item.photo)
            statusImage.setImageResource(item.statusImage)
        }
    }
}