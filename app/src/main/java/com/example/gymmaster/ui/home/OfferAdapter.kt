package com.example.gymmaster.ui.home
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class OfferAdapter(private val offers: List<Offer>) :
    RecyclerView.Adapter<OfferAdapter.OfferViewHolder>() {

    inner class OfferViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val offerTitle: TextView = view.findViewById(R.id.offerTitle)
        val offerPrice: TextView = view.findViewById(R.id.offerPrice)
        val offerPersons: TextView = view.findViewById(R.id.offerPersons)
        val offerDetails: TextView = view.findViewById(R.id.offerDetails)
        val offerDuration: TextView = view.findViewById(R.id.offerDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_offer, parent, false)
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offer = offers[position]
        holder.offerTitle.text = offer.title
        holder.offerPrice.text = "Price: ${offer.price} DA"
        holder.offerPersons.text = "Persons: ${offer.persons}"
        holder.offerDetails.text = offer.details
        holder.offerDuration.text = "Duration: ${offer.duration} mins"
    }

    override fun getItemCount(): Int = offers.size
}
