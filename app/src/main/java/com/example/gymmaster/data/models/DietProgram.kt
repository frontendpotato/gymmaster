package com.example.gymmaster.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.io.Serializable





data class Meal(
    val id: String,
    @StringRes val nameResId: Int,
    val ingredients: List<MealIngredient>,
    val mainResource: String // e.g., "protein", "carbs", "fats"
) : Serializable {
    // Calculate total macros for the meal
    val totalCalories: Int
        get() = ingredients.sumOf { it.calories }
    
    val totalProtein: Double
        get() = ingredients.sumOf { it.protein }
    
    val totalCarbs: Double
        get() = ingredients.sumOf { it.carbs }
    
    val totalFat: Double
        get() = ingredients.sumOf { it.fat }
}

data class MealIngredient(
    val nameResId: Int,
    val quantity: Int,
    val unit: String,
    val calories: Int,
    val protein: Double,
    val carbs: Double,
    val fat: Double
) : Serializable

/*
data class Meal(
    val id: String,
    @StringRes val nameResId: Int,
    @StringRes val descriptionResId: Int,
    @DrawableRes val imageResId: Int,
    val calories: Int,
    val protein: Int,
    val carbs: Int,
    val fat: Int,
    val ingredients: List<String>,
    val instructions: List<String>
) */
