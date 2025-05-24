package com.example.gymmaster.ui.diet

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.models.DietProgram
import com.example.gymmaster.data.models.Meal

class DietDetailsActivity : AppCompatActivity() {

    private lateinit var dietProgram: DietProgram
    private lateinit var mealsAdapter: MealsAdapter

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

        // Setup meals RecyclerView
        val mealsRecyclerView = findViewById<RecyclerView>(R.id.mealsRecyclerView)
        mealsRecyclerView.layoutManager = LinearLayoutManager(this)
        
        // Group meals by day (for now, we'll just show all meals in sequence)
        val meals = dietProgram.meals
        
        mealsAdapter = MealsAdapter(meals) { meal ->
            // Handle meal click if needed
        }
        
        mealsRecyclerView.adapter = mealsAdapter
    }
} 