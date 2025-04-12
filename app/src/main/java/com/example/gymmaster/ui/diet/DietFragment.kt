package com.example.gymmaster.ui.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.SampleDietData
import com.example.gymmaster.data.models.DietProgram
import com.example.gymmaster.data.models.NutritionCategory

class DietFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDietProgramsRecyclerView(view)
        setupNutritionCategoriesRecyclerView(view)
    }

    private fun setupDietProgramsRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.dietProgramsRecyclerView)
        
        // Filter out only DietProgram objects
        val dietPrograms = SampleDietData.dietPrograms.filterIsInstance<DietProgram>()
        
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        
        val adapter = DietProgramAdapter(dietPrograms) { dietProgram ->
            // Handle diet program click
            Toast.makeText(
                requireContext(),
                getString(dietProgram.nameResId),
                Toast.LENGTH_SHORT
            ).show()
            
            // TODO: Navigate to diet program details
        }
        
        recyclerView.adapter = adapter
    }

    private fun setupNutritionCategoriesRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.nutritionCategoriesRecyclerView)
        
        // Use the dedicated nutritionCategories list instead of filtering
        val nutritionCategories = SampleDietData.nutritionCategories
        
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        
        val adapter = NutritionCategoryAdapter(nutritionCategories) { nutritionCategory ->
            // Handle nutrition category click
            Toast.makeText(
                requireContext(),
                getString(nutritionCategory.nameResId),
                Toast.LENGTH_SHORT
            ).show()
            
            // TODO: Navigate to nutrition category details
        }
        
        recyclerView.adapter = adapter
    }
} 