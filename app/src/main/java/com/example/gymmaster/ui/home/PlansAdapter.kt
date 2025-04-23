package com.example.gymmaster.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import java.util.Locale

class PlansAdapter(private val plans: List<Plan>) :
    RecyclerView.Adapter<PlansAdapter.PlanViewHolder>() {

    class PlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.planTitle)
        val price: TextView = itemView.findViewById(R.id.planPrice)
        val duration: TextView = itemView.findViewById(R.id.planDuration)
        val background: RelativeLayout = itemView.findViewById(R.id.cardBackground)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plan, parent, false)
        return PlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        val plan = plans[position]
        holder.title.text = plan.title
        holder.price.text = "Price: ${plan.price} DZD"
        holder.duration.text = "Duration: ${plan.durationDays} days"

        when (plan.tier.lowercase(Locale.getDefault())) {
            "gold" -> holder.background.setBackgroundResource(R.drawable.bg_gold)
            "silver" -> holder.background.setBackgroundResource(R.drawable.bg_silver)
            //"bronze" -> holder.background.setBackgroundResource(R.drawable.bg_bronze)
            else -> holder.background.setBackgroundResource(R.drawable.bg_black)
        }
    }

    override fun getItemCount(): Int = plans.size
}
