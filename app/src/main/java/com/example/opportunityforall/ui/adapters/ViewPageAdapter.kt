package com.example.opportunityforall.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.opportunityforall.R
import com.example.opportunityforall.R.drawable.*

data class OnboardingWelcome(
    var text_main: String,
    var text_description: String,
    var image: Int
)

class ViewPageAdapter(context: Context) : RecyclerView.Adapter<ViewPageAdapter.PagerVH>() {

    private val array = arrayOf(
        OnboardingWelcome("Welcome to FLOW!", "This app is designed to help student-athletes earn and sponsors get quality services.", deal),
        OnboardingWelcome("Reliability", "All student-athletes are vetted and approved by the universities. All deals are backed by official contracts and are legally binding.", reliability),
        OnboardingWelcome("Request", "Sponsor chooses the athlete and requests to cooperate", request),
        OnboardingWelcome("Start chatting", "If the student-athlete is interested in the offer, he/she initiates a discussion about the conditions in the chat room", start_chating),
        OnboardingWelcome("Discussion and finalization", "Once the parties have agreed and finalized the contract, FLOW lawyers contact them and help them draw up the necessary papers to begin the contract.", discussion_and_finalization),
        OnboardingWelcome("Escrow funds", "Once the paperwork is done, the sponsor is charged the amount of money to pay the athlete.", escrow_funds),
        OnboardingWelcome("Confirmation and payment", "Upon completion of the event, both parties must indicate in the FLOW App that it has taken place. After that, the previously withheld amount is transferred to the athlete.", confirmation_and_payment),
        OnboardingWelcome("That's all", "After leaving reviews of each other, the cooperation between the parties is considered completed.", thats_all)
    )

    class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.text_view_main)
        var description: TextView = itemView.findViewById(R.id.text_vew_description)
        var image: ImageView = itemView.findViewById(R.id.description_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        return PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    override fun getItemCount(): Int = array.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        holder.title.text = array[position].text_main
        holder.description.text = array[position].text_description
        holder.image.setImageResource(array[position].image)
    }
}