package com.example.gymmaster.ui.diet

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.models.NutritionCategory

class NutritionDetailsActivity : AppCompatActivity() {

    private lateinit var nutritionCategory: NutritionCategory
    private lateinit var ingredientsAdapter: IngredientsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_details)

        // Get the nutrition category from intent
        nutritionCategory = intent.getSerializableExtra("nutrition_category") as NutritionCategory

        // Setup toolbar
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            onBackPressed()
        }

        // Set title
        findViewById<TextView>(R.id.titleTextView).text = getString(nutritionCategory.nameResId)

        // Setup ingredients RecyclerView
        val ingredientsRecyclerView = findViewById<RecyclerView>(R.id.ingredientsRecyclerView)
        ingredientsRecyclerView.layoutManager = LinearLayoutManager(this)
        
        ingredientsAdapter = IngredientsAdapter(nutritionCategory.ingredients)
        ingredientsRecyclerView.adapter = ingredientsAdapter
    }
} 