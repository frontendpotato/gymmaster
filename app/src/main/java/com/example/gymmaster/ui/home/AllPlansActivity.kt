package com.example.gymmaster.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.google.firebase.firestore.FirebaseFirestore

class AllPlansActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PlansAdapter
    private val plans = mutableListOf<Plan>()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_plans)

        recyclerView = findViewById(R.id.plansRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PlansAdapter(plans)
        recyclerView.adapter = adapter

        fetchPlans()
    }

    private fun fetchPlans() {
        db.collection("Gym")
            .document("gym1")
            .collection("plans")
            .get()
            .addOnSuccessListener { result ->
                plans.clear()
                for (document in result) {
                    val plan = document.toObject(Plan::class.java)
                    plans.add(plan)
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to load plans", Toast.LENGTH_SHORT).show()
            }
    }
}
