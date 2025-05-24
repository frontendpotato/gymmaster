package com.example.gymmaster.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R

class OffersAdapter(
    private val offers: List<Offer>,
    private val onItemClick: (Offer) -> Unit
) : RecyclerView.Adapter<OffersAdapter.OfferViewHolder>() {

    private var selectedOffer: Offer? = null

    inner class OfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.offerTitle)
        val price: TextView = itemView.findViewById(R.id.offerPrice)
        val duration: TextView = itemView.findViewById(R.id.offerDuration)
        val persons: TextView = itemView.findViewById(R.id.offerPersons)

        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(offers[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_offer, parent, false)
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offer = offers[position]
        holder.title.text = offer.title
        holder.price.text = offer.price
        holder.duration.text = offer.duration
        holder.persons.text = offer.persons.toString()

        // Highlight selected offer
        if (offer == selectedOffer) {
            holder.itemView.setBackgroundResource(R.drawable.selected_offer_background)
        } else {
            holder.itemView.background = null
        }
    }

    override fun getItemCount(): Int = offers.size

    fun setSelectedOffer(offer: Offer) {
        val previousSelected = selectedOffer
        selectedOffer = offer
        notifyDataSetChanged()
    }
} 