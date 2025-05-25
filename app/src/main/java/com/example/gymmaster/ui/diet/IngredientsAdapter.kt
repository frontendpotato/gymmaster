package com.example.gymmaster.ui.diet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.Ingredient

class IngredientsAdapter(private val ingredients: List<Ingredient>) : 
    RecyclerView.Adapter<IngredientsAdapter.IngredientViewHolder>() {

    class IngredientViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.ingredientNameTextView)
        val quantityTextView: TextView = view.findViewById(R.id.ingredientQuantityTextView)
        val caloriesTextView: TextView = view.findViewById(R.id.ingredientCaloriesTextView)
        val proteinTextView: TextView = view.findViewById(R.id.ingredientProteinTextView)
        val carbsTextView: TextView = view.findViewById(R.id.ingredientCarbsTextView)
        val fatsTextView: TextView = view.findViewById(R.id.ingredientFatsTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ingredient, parent, false)
        return IngredientViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val ingredient = ingredients[position]
        val context = holder.itemView.context
        
        holder.nameTextView.text = context.getString(ingredient.nameResId)
        holder.quantityTextView.text = "${ingredient.quantity}${ingredient.unit}"
        holder.caloriesTextView.text = ingredient.calories.toString()
        holder.proteinTextView.text = ingredient.protein.toString()
        holder.carbsTextView.text = ingredient.carbs.toString()
        holder.fatsTextView.text = ingredient.fat.toString()
    }

    override fun getItemCount() = ingredients.size
} 