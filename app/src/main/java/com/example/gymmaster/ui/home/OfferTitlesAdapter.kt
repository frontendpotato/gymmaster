package com.example.gymmaster.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R

class OfferTitlesAdapter(
    private val offers: List<Offer>,
    private val onOfferClick: (Offer) -> Unit
) : RecyclerView.Adapter<OfferTitlesAdapter.OfferTitleViewHolder>() {

    inner class OfferTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.offerTitleTab)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferTitleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_offer_title_tab, parent, false)
        return OfferTitleViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferTitleViewHolder, position: Int) {
        val offer = offers[position]
        holder.titleView.text = offer.title

        holder.itemView.setOnClickListener {
            onOfferClick(offer)
        }
    }

    override fun getItemCount(): Int = offers.size
}
