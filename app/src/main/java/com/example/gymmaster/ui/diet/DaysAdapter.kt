/*
package com.example.gymmaster.ui.diet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.models.Day
import com.example.gymmaster.data.models.Meal

class DaysAdapter(
    private val days: List<Day>,
    private val onDayClick: (Day) -> Unit,
    private val onMealClick: (Meal) -> Unit
) : RecyclerView.Adapter<DaysAdapter.DayViewHolder>() {

    class DayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayTitleTextView: TextView = view.findViewById(R.id.dayTitleTextView)
        val mealsRecyclerView: RecyclerView = view.findViewById(R.id.mealsRecyclerView)
        val totalCaloriesTextView: TextView = view.findViewById(R.id.totalCaloriesTextView)
        val totalProteinTextView: TextView = view.findViewById(R.id.totalProteinTextView)
        val totalCarbsTextView: TextView = view.findViewById(R.id.totalCarbsTextView)
        val totalFatTextView: TextView = view.findViewById(R.id.totalFatTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val day = days[position]
        val context = holder.itemView.context

        // Set day title
        holder.dayTitleTextView.text = context.getString(R.string.day_number, position + 1)

        // Setup meals RecyclerView
        holder.mealsRecyclerView.layoutManager = LinearLayoutManager(context)
        holder.mealsRecyclerView.adapter = MealsAdapter(day.meals, onMealClick)

        // Calculate and set total macros
        val totalCalories = day.meals.sumOf { it.totalCalories }
        val totalProtein = day.meals.sumOf { it.totalProtein }
        val totalCarbs = day.meals.sumOf { it.totalCarbs }
        val totalFat = day.meals.sumOf { it.totalFat }

        holder.totalCaloriesTextView.text = context.getString(R.string.calories_format, totalCalories)
        holder.totalProteinTextView.text = context.getString(R.string.protein_format, totalProtein)
        holder.totalCarbsTextView.text = context.getString(R.string.carbs_format, totalCarbs)
        holder.totalFatTextView.text = context.getString(R.string.fat_format, totalFat)

        // Set click listener
        holder.itemView.setOnClickListener { onDayClick(day) }
    }

    override fun getItemCount() = days.size
} */
