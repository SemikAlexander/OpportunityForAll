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
            requestAthleteItemVew.setOnClickListener { onItemClick.invoke(item) }

            imageRequest.setImageResource(item.image)
            statusRequest.text = item.status
            dateRequest.text = item.date
            typeRequest.text = item.type
            name.text = item.name
            photo.setImageResource(item.photo)
            descriptionRequest.text = item.description
        }
    }
}