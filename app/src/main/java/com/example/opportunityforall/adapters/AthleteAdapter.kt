//package com.example.opportunityforall.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.example.opportunityforall.databinding.AthletesRecycleViewBinding
//
//class AthleteAdapter (
//    private val onItemClick: (Athlete) -> Unit
//) : RecyclerView.Adapter<Athlete, AthleteAdapter.MyViewHolder>(FilmsDiffUtil)  {
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): MyViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return MyViewHolder(AthletesRecycleViewBinding.inflate(inflater, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        getItem(position)?.let(holder::bind)
//    }
//
//    inner class MyViewHolder(private val binding: AthletesRecycleViewBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(item: Athlete) = binding.run {
//
//        }
//    }
//}
//
//object FilmsDiffUtil : DiffUtil.ItemCallback<Athlete>() {
//
//    override fun areItemsTheSame(oldItem: Athlete, newItem: Athlete): Boolean =
//        oldItem.id == newItem.id
//
//    override fun areContentsTheSame(oldItem: Athlete, newItem: Athlete): Boolean =
//        oldItem == newItem
//}