package com.example.opportunityforall.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.opportunityforall.databinding.AthletesRecycleViewBinding
import com.example.opportunityforall.ui.adapters.classes.Athlete
import com.google.android.material.shape.CornerFamily

class AthleteAdapter (
    private val values: ArrayList<Athlete>,
    private val onItemClick: (Athlete) -> Unit
) : RecyclerView.Adapter<AthleteAdapter.MyViewHolder>()  {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(
            AthletesRecycleViewBinding.inflate(
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
        private val binding: AthletesRecycleViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Athlete) = binding.run {
            athleteItemView.setOnClickListener { onItemClick.invoke(item) }

            nameAthlete.text = item.nameAthlete
            cityAthlete.text = item.cityAthlete
            sportAthlete.text = item.sportAthlete

            val radius = 50.0f
            photoAthlete.shapeAppearanceModel = photoAthlete.shapeAppearanceModel
                .toBuilder()
                .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                .build();

            photoAthlete.setImageResource(item.photoAthlete)
        }
    }
}
