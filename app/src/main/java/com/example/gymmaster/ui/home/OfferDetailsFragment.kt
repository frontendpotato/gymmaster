package com.example.gymmaster.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gymmaster.R

class OfferDetailsFragment : Fragment() {

    private lateinit var offer: Offer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        offer = arguments?.getSerializable("offer") as Offer
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_offer_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.offerDetails).text = offer.details
        view.findViewById<TextView>(R.id.offerDuration).text = "Duration: ${offer.duration}"
        view.findViewById<TextView>(R.id.offerPersons).text = "For ${offer.persons} person(s)"
        view.findViewById<TextView>(R.id.offerPrice).text = "£${offer.price}"
    }

    companion object {
        fun newInstance(offer: Offer): OfferDetailsFragment {
            val fragment = OfferDetailsFragment()
            val args = Bundle()
            args.putSerializable("offer", offer)
            fragment.arguments = args
            return fragment
        }
    }
}
