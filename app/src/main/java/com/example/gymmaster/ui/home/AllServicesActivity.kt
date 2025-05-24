package com.example.gymmaster.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.google.firebase.firestore.FirebaseFirestore

class AllServicesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ServiceAdapter
    private val serviceList = mutableListOf<Service>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_services)

        // Setup toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "All Services"

        // Initialize RecyclerView with GridLayoutManager
        recyclerView = findViewById(R.id.servicesRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns
        
        adapter = ServiceAdapter(serviceList) { selectedService ->
            val intent = Intent(this, ServiceDetailsActivity::class.java)
            intent.putExtra("service", selectedService)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        // Load all services
        loadAllServices()
    }

    private fun loadAllServices() {
        db.collection("Gym")
            .document("gym1")
            .collection("services")
            .get()
            .addOnSuccessListener { snapshot ->
                serviceList.clear()
                for (doc in snapshot) {
                    val service = doc.toObject(Service::class.java).copy(id = doc.id)
                    serviceList.add(service)
                }
                adapter.notifyDataSetChanged()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
} 