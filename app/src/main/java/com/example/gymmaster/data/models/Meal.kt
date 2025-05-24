package com.example.gymmaster.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.io.Serializable

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
) : Serializable 