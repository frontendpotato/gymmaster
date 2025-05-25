package com.example.gymmaster.data.models

import androidx.annotation.StringRes
import com.example.gymmaster.data.Ingredient
import java.io.Serializable

data class NutritionCategory(
    val id: String,
    @StringRes val nameResId: Int,
    @StringRes val descriptionResId: Int,
    val ingredients: List<Ingredient>
) : Serializable 