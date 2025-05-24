package com.example.gymmaster.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*
import android.widget.ImageView

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val productList = mutableListOf<Product>()
    private lateinit var adapter: ProductAdapter
    private val db = FirebaseFirestore.getInstance()

    private lateinit var planCard: View
    private lateinit var planTitle: TextView
    private lateinit var planDaysLeft: TextView
    private lateinit var planExpiryDate: TextView
    private lateinit var btnShowPlans: Button
    private lateinit var planBackground: ImageView

    //services vars
    private lateinit var servicesRecyclerView: RecyclerView
    private lateinit var serviceAdapter: ServiceAdapter
    private lateinit var seeMoreServicesBtn: Button
    private val serviceList = mutableListOf<Service>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        adapter = ProductAdapter(productList) { product ->
            val intent = Intent(requireContext(), ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        planCard = view.findViewById(R.id.activePlanSection)
        planTitle = view.findViewById(R.id.planTitle)
        planDaysLeft = view.findViewById(R.id.planDaysLeft)
        planExpiryDate = view.findViewById(R.id.planExpiryDate)
        btnShowPlans = view.findViewById(R.id.btnShowPlans)
        planBackground = view.findViewById(R.id.planBackground)

        btnShowPlans.setOnClickListener {
            startActivity(Intent(requireContext(), AllPlansActivity::class.java))
        }

        val showMore = view.findViewById<TextView>(R.id.showMore)
        showMore.setOnClickListener {
            startActivity(Intent(requireContext(), AllServicesActivity::class.java))
        }

        fetchActivePlan()
        loadLatestProducts()

        // Reference RecyclerView
        servicesRecyclerView = view.findViewById(R.id.servicesRecyclerView)

        // Setup adapter and RecyclerView
        setupServicesRecyclerView()

        // Fetch preview data
        fetchServicesPreview()

        return view
    }

    private fun loadLatestProducts() {
        db.collection("Gym").document("gym1").collection("Products")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .limit(4)
            .get()
            .addOnSuccessListener { snapshot ->
                productList.clear()
                for (doc in snapshot.documents) {
                    val product = doc.toObject(Product::class.java)
                    if (product != null) {
                        productList.add(product)
                    }
                }
                adapter.notifyDataSetChanged()
            }
    }

    private fun setupServicesRecyclerView() {
        serviceAdapter = ServiceAdapter(serviceList) { selectedService ->
            val intent = Intent(requireContext(), ServiceDetailsActivity::class.java)
            intent.putExtra("service", selectedService)
            startActivity(intent)
        }

        servicesRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        servicesRecyclerView.adapter = serviceAdapter
    }

    private fun fetchServicesPreview() {
        db.collection("Gym")
            .document("gym1")
            .collection("services")
            .limit(4)
            .get()
            .addOnSuccessListener { snapshot ->
                serviceList.clear()
                for (doc in snapshot) {
                    val service = doc.toObject(Service::class.java).copy(id = doc.id)
                    serviceList.add(service)
                }
                serviceAdapter.notifyDataSetChanged()
            }
    }

    private fun fetchActivePlan() {
        val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return

        db.collection("users")
            .document(uid)
            .get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val activePlanDetails = document.get("activePlanDetails") as? Map<*, *>

                    if (activePlanDetails != null) {
                        val title = activePlanDetails["title"] as? String ?: "no-title"
                        val tier = (activePlanDetails["tier"] as? String ?: "no-tier").lowercase(Locale.getDefault())
                        val endDateTimestamp = activePlanDetails["endDate"] as? com.google.firebase.Timestamp
                        val startDateTimestamp = activePlanDetails["startDate"] as? com.google.firebase.Timestamp

                        // Set background based on tier on planBackground
                        when (tier) {
                            "gold" -> planBackground.setImageResource(R.drawable.gold)
                            "silver" -> planBackground.setImageResource(R.drawable.silver)
                            "bronze" -> planBackground.setImageResource(R.drawable.bronze)
                            "platinum" -> planBackground.setImageResource(R.drawable.platinum)
                            "diamond" -> planBackground.setImageResource(R.drawable.diamond)
                            "emerald" -> planBackground.setImageResource(R.drawable.emerald)
                            "sapphire" -> planBackground.setImageResource(R.drawable.saphire)
                            "titanuim" -> planBackground.setImageResource(R.drawable.platinum)
                            else -> planBackground.setImageResource(R.drawable.bg_silver)
                        }

                        if (endDateTimestamp != null && startDateTimestamp != null) {
                            val endDate = endDateTimestamp.toDate()
                            val today = Calendar.getInstance().time
                            val remainingDays = ((endDate.time - today.time) / (1000 * 60 * 60 * 24)).toInt()

                            planTitle.text = "Your Plan: $title"
                            planDaysLeft.text = "$remainingDays Days Left"
                            planExpiryDate.text = "Ends: ${SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(endDate)}"

                            planCard.visibility = View.VISIBLE
                        } else {
                            planCard.visibility = View.GONE
                        }

                    } else {
                        planCard.visibility = View.GONE
                    }
                } else {
                    planCard.visibility = View.GONE
                }
            }
            .addOnFailureListener {
                planCard.visibility = View.GONE
            }
    }
}


