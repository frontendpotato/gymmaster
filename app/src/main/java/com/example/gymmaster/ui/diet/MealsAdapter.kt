package com.example.gymmaster.ui.diet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.models.Meal

class MealsAdapter(
    private val meals: List<Meal>,
    private val onMealClick: (Meal) -> Unit
) : RecyclerView.Adapter<MealsAdapter.MealViewHolder>() {

    class MealViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mealName: TextView = view.findViewById(R.id.mealName)
        val caloriesText: TextView = view.findViewById(R.id.caloriesText)
        val macrosText: TextView = view.findViewById(R.id.macrosText)
       // val ingredientsCount: TextView = view.findViewById(R.id.ingredientsCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = meals[position]
        val context = holder.itemView.context
        
        holder.mealName.text = context.getString(meal.nameResId)
        
        // Format macros
        holder.caloriesText.text = "${meal.totalCalories} kcal"
        holder.macrosText.text = "P: ${meal.totalProtein}g | C: ${meal.totalCarbs}g | F: ${meal.totalFat}g"
      //  holder.ingredientsCount.text = "${meal.ingredients.size} ingredients"
        
        holder.itemView.setOnClickListener {
            onMealClick(meal)
        }
    }

    override fun getItemCount() = meals.size
} 