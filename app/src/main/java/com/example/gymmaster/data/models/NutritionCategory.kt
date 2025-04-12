package com.example.gymmaster.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NutritionCategory(
    val id: String,
    @StringRes val nameResId: Int,
    @StringRes val descriptionResId: Int,
    @DrawableRes val imageResId: Int,
    val foods: List<Food>
)

data class Food(
    val id: String,
    @StringRes val nameResId: Int,
    val calories: Int,
    val protein: Int,
    val carbs: Int,
    val fat: Int,
    @DrawableRes val imageResId: Int
) 