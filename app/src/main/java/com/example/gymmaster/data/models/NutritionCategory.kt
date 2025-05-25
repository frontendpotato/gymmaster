package com.example.gymmaster.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.io.Serializable

data class NutritionCategory(
    val id: String,
    @StringRes val nameResId: Int,
    @StringRes val descriptionResId: Int,
    @DrawableRes val imageResId: Int,
    val ingredients: List<MealIngredient>
) : Serializable 