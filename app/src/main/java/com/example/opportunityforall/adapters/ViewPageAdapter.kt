package com.example.opportunityforall.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.opportunityforall.R

class ViewPageAdapter(context: Context) : RecyclerView.Adapter<ViewPageAdapter.PagerVH>() {

    private val array = arrayOf(
        arrayListOf("Lorem ipsum dolorsit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mi mattis odio pretium sed a eget scelerisque rhoncus."),
        arrayListOf("Mi mattis odio pretium sed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mi mattis odio pretium sed a eget scelerisque rhoncus."),
        arrayListOf("Bibendum facilisi pharea volutpat ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mi mattis odio pretium sed a eget scelerisque rhoncus.")
    )

    class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.title_text)
        var description: TextView = itemView.findViewById(R.id.description_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        return PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        holder.title.text = array[position][0]
        holder.description.text = array[position][1]
    }
}