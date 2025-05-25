package com.example.gymmaster.ui.diet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymmaster.R
import com.example.gymmaster.data.models.NutritionCategory
import com.google.android.material.button.MaterialButton

class NutritionCategoryAdapter(
    private val nutritionCategories: List<NutritionCategory>,
    private val onNutritionCategoryClick: (NutritionCategory) -> Unit
) : RecyclerView.Adapter<NutritionCategoryAdapter.NutritionCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionCategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nutrition_category, parent, false)
        return NutritionCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: NutritionCategoryViewHolder, position: Int) {
        holder.bind(nutritionCategories[position])
    }

    override fun getItemCount() = nutritionCategories.size

    inner class NutritionCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nutritionCategoryImage: ImageView = itemView.findViewById(R.id.nutritionCategoryImage)
        private val nutritionCategoryName: TextView = itemView.findViewById(R.id.nutritionCategoryName)
        private val nutritionCategoryDescription: TextView = itemView.findViewById(R.id.nutritionCategoryDescription)
      //  private val ingredientsCount: TextView = itemView.findViewById(R.id.ingredientsCount)
        private val viewDetailsButton: MaterialButton = itemView.findViewById(R.id.viewDetailsButton)

        fun bind(nutritionCategory: NutritionCategory) {
            Glide.with(itemView.context)
                .load(nutritionCategory.imageResId)
                .centerCrop()
                .into(nutritionCategoryImage)
                
            nutritionCategoryName.setText(nutritionCategory.nameResId)
            nutritionCategoryDescription.setText(nutritionCategory.descriptionResId)
        //    ingredientsCount.text = "${nutritionCategory.ingredients.size} ingredients"
            
            viewDetailsButton.setOnClickListener { onNutritionCategoryClick(nutritionCategory) }
            itemView.setOnClickListener { onNutritionCategoryClick(nutritionCategory) }
        }
    }
} 