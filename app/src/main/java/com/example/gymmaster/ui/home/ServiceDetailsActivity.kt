package com.example.gymmaster.ui.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymmaster.R
import com.google.firebase.firestore.FirebaseFirestore
import com.example.gymmaster.ui.home.Service

class ServiceDetailsActivity : AppCompatActivity() {

    private lateinit var service: Service

    private lateinit var serviceTitle: TextView
    private lateinit var serviceDescription: TextView
    private lateinit var serviceImagesRecyclerView: RecyclerView
    private lateinit var serviceImagesAdapter: ServiceImagesAdapter


    private lateinit var offerTitlesAdapter: OfferTitlesAdapter

    private lateinit var offerDetailsFragmentContainer: FrameLayout
    private lateinit var bookButton: Button

    private val db = FirebaseFirestore.getInstance()
    private val offers = mutableListOf<Offer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_details)

        // Get the service passed from HomeFragment
        service = intent.getSerializableExtra("service") as Service

        // Bind views
        serviceTitle = findViewById(R.id.serviceTitle)
        serviceDescription = findViewById(R.id.serviceDescription)
        serviceImagesRecyclerView = findViewById(R.id.imagesRecyclerView)

        offerDetailsFragmentContainer = findViewById(R.id.offerDetailsFragmentContainer)
        bookButton = findViewById(R.id.bookButton)

        // Set service content
        serviceTitle.text = service.name
        serviceDescription.text = service.description

        // Set up service images RecyclerView
        serviceImagesAdapter = ServiceImagesAdapter(service.images)
        serviceImagesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        serviceImagesRecyclerView.adapter = serviceImagesAdapter

        // Load offers for the selected service
        fetchOffers()
    }

    private fun fetchOffers() {
        db.collection("services").document(service.id)
            .collection("offers")
            .get()
            .addOnSuccessListener { snapshot ->
                Log.d("ServiceDetails", "Raw snapshot size: ${snapshot.size()}")
                for (doc in snapshot.documents) {
                    Log.d("ServiceDetails", "Doc: ${doc.id} → ${doc.data}")
                }
                Log.d("ServiceDetails", "Offers found: ${snapshot.size()}")
                offers.clear()
                for (doc in snapshot.documents) {
                    val offer = doc.toObject(Offer::class.java)
                    if (offer != null) {
                        offer.id = doc.id
                        offers.add(offer)
                    }
                }

                Log.d("ServiceDetails", "Offers added: ${offers.size}")

                setupOfferTabs()

                if (offers.isNotEmpty()) {
                    Log.d("ServiceDetails", "Calling loadOfferFragment with: ${offers.first().title}")
                    loadOfferFragment(offers.first())
                } else {
                    Log.d("ServiceDetails", "No offers found for service: ${service.id}")
                }
            }
            .addOnFailureListener {
                Log.e("ServiceDetails", "Error fetching offers: ${it.message}", it)
            }
    }


    private fun setupOfferTabs() {
        val tabBar = findViewById<LinearLayout>(R.id.offersTabBar)
        tabBar.removeAllViews() // Clear any existing tabs

        for ((index, offer) in offers.withIndex()) {
            val tab = TextView(this).apply {
                text = offer.title
                setPadding(32, 16, 32, 16)
                setTextColor(Color.BLACK)
                textSize = 16f
 //               setBackgroundResource(R.drawable.offer_tab_background) // optional styling
                isClickable = true
                isFocusable = true

                setOnClickListener {
                    loadOfferFragment(offer)
                    highlightSelectedTab(this, tabBar)
                }
            }

            tabBar.addView(tab)

            // Automatically select the first offer
            if (index == 0) {
                tab.performClick()
            }
        }
    }

    private fun highlightSelectedTab(selectedTab: TextView, tabBar: LinearLayout) {
        for (i in 0 until tabBar.childCount) {
            val tab = tabBar.getChildAt(i) as TextView
            tab.setTextColor(Color.GRAY)
            tab.setBackgroundResource(android.R.color.transparent)
        }
        selectedTab.setTextColor(Color.BLACK)
    }


/*    private fun loadOfferFragment(offer: Offer) {
        val fragment = OfferDetailsFragment.newInstance(offer)
        supportFragmentManager.beginTransaction()
            .replace(R.id.offerDetailsFragmentContainer, fragment)
            .commit()
    }*/
private fun loadOfferFragment(offer: Offer) {
    Log.d("ServiceDetails", "Loading offer fragment: ${offer.title}")
    Toast.makeText(this, "Loading ${offer.title}", Toast.LENGTH_SHORT).show()
    val fragment = OfferDetailsFragment.newInstance(offer)
    supportFragmentManager.beginTransaction()
        .replace(R.id.offerDetailsFragmentContainer, fragment)
        .commit()
}

}

