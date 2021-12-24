package com.example.opportunityforall.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.opportunityforall.databinding.AthleteRequestsRecycleViewBinding
import com.example.opportunityforall.ui.adapters.classes.RequestsAthlete

class RequestsAthleteAdapter (
    private val values: ArrayList<RequestsAthlete>,
    private val onItemClick: (RequestsAthlete) -> Unit
) : RecyclerView.Adapter<RequestsAthleteAdapter.MyViewHolder>()  {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(
            AthleteRequestsRecycleViewBinding.inflate(
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
        private val binding: AthleteRequestsRecycleViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RequestsAthlete) = binding.run {
            athleteRequestItemView.setOnClickListener { onItemClick.invoke(item) }

            typeRequest.text = item.typeRequests
            name.text = item.name
            statusRequest.text = item.statusRequest
            description.text = item.description
            imageRequest.setImageResource(item.imageRequests)
            photo.setImageResource(item.photo)
        }
    }
}