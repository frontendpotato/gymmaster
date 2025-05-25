/*
package com.example.gymmaster.ui.diet

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.models.DietProgram
import com.example.gymmaster.data.models.Day
import com.example.gymmaster.data.models.Meal

class DietDetailsActivity : AppCompatActivity() {

    private lateinit var dietProgram: DietProgram
    private lateinit var daysAdapter: DaysAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_details)

        // Get the diet program from intent
        dietProgram = intent.getSerializableExtra("diet_program") as DietProgram

        // Setup toolbar
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressed()
        }

        // Set title
        findViewById<TextView>(R.id.titleTextView).text = getString(dietProgram.nameResId)

        // Setup days RecyclerView
        val daysRecyclerView = findViewById<RecyclerView>(R.id.mealsRecyclerView)
        daysRecyclerView.layoutManager = LinearLayoutManager(this)
        
        daysAdapter = DaysAdapter(
            days = dietProgram.days,
            onDayClick = { day ->
                // Handle day click if needed
            },
            onMealClick = { meal ->
                // Handle meal click if needed
            }
        )
        
        daysRecyclerView.adapter = daysAdapter
    }
} */
