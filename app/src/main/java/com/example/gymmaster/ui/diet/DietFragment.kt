package com.example.gymmaster.ui.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.NutritionData

class DietFragment : Fragment() {

    private lateinit var nutritionCategoryAdapter: NutritionCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.nutritionCategoriesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Setup adapter
        nutritionCategoryAdapter = NutritionCategoryAdapter(
            nutritionCategories = NutritionData.nutritionCategories,
            onNutritionCategoryClick = { nutritionCategory ->
                // Navigate to nutrition details
                val intent = NutritionDetailsActivity.newIntent(requireContext(), nutritionCategory)
                startActivity(intent)
            }
        )

        recyclerView.adapter = nutritionCategoryAdapter
    }
} 