package com.example.gymmaster.ui.diet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.models.Meal

class MealsAdapter(
    private val meals: List<Meal>,
    private val onMealClick: (Meal) -> Unit
) : RecyclerView.Adapter<MealsAdapter.MealViewHolder>() {

    class MealViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mealImage: ImageView = view.findViewById(R.id.mealImage)
        val mealName: TextView = view.findViewById(R.id.mealName)
        val mealDescription: TextView = view.findViewById(R.id.mealDescription)
        val caloriesText: TextView = view.findViewById(R.id.caloriesText)
        val macrosText: TextView = view.findViewById(R.id.macrosText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = meals[position]
        
        holder.mealImage.setImageResource(meal.imageResId)
        holder.mealName.text = holder.itemView.context.getString(meal.nameResId)
        holder.mealDescription.text = holder.itemView.context.getString(meal.descriptionResId)
        
        // Format macros
        holder.caloriesText.text = "${meal.calories} kcal"
        holder.macrosText.text = "P: ${meal.protein}g | C: ${meal.carbs}g | F: ${meal.fat}g"
        
        holder.itemView.setOnClickListener {
            onMealClick(meal)
        }
    }

    override fun getItemCount() = meals.size
} 