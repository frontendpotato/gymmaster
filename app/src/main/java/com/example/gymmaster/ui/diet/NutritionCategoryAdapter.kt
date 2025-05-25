package com.example.gymmaster.ui.diet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.models.NutritionCategory
import com.example.gymmaster.databinding.ItemNutritionCategoryBinding

class NutritionCategoryAdapter(
    private val categories: List<NutritionCategory>,
    private val onCategoryClick: (NutritionCategory) -> Unit
) : RecyclerView.Adapter<NutritionCategoryAdapter.NutritionCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionCategoryViewHolder {
        val binding = ItemNutritionCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NutritionCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NutritionCategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    inner class NutritionCategoryViewHolder(
        private val binding: ItemNutritionCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onCategoryClick(categories[position])
                }
            }
        }

        fun bind(category: NutritionCategory) {
            binding.apply {
                nutritionCategoryName.setText(category.nameResId)
                nutritionCategoryDescription.setText(category.descriptionResId)
                ingredientsCount.text = root.context.getString(
                    R.string.ingredients_count,
                    category.ingredients.size
                )
            }
        }
    }
} 