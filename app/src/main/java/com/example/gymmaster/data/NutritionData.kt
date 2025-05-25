package com.example.gymmaster.data

import com.example.gymmaster.R
import com.example.gymmaster.data.models.MealIngredient

object NutritionData {
    // Protein Sources
    val proteinSources = listOf(
        MealIngredient(
            nameResId = R.string.food_chicken_breast,
            quantity = 100,
            unit = "g",
            calories = 165,
            protein = 31.0,
            carbs = 0.0,
            fat = 3.0
        ),
        MealIngredient(
            nameResId = R.string.food_eggs,
            quantity = 1,
            unit = "piece",
            calories = 155,
            protein = 13.0,
            carbs = 1.0,
            fat = 11.0
        ),
        MealIngredient(
            nameResId = R.string.food_greek_yogurt,
            quantity = 100,
            unit = "g",
            calories = 59,
            protein = 10.0,
            carbs = 3.0,
            fat = 0.0
        ),
        MealIngredient(
            nameResId = R.string.food_salmon,
            quantity = 100,
            unit = "g",
            calories = 208,
            protein = 22.0,
            carbs = 0.0,
            fat = 13.0
        ),
        MealIngredient(
            nameResId = R.string.food_whey_protein,
            quantity = 30,
            unit = "g",
            calories = 120,
            protein = 24.0,
            carbs = 3.0,
            fat = 2.0
        )
    )

    // Carb Sources
    val carbSources = listOf(
        MealIngredient(
            nameResId = R.string.food_brown_rice,
            quantity = 100,
            unit = "g",
            calories = 112,
            protein = 2.0,
            carbs = 23.0,
            fat = 1.0
        ),
        MealIngredient(
            nameResId = R.string.food_sweet_potato,
            quantity = 100,
            unit = "g",
            calories = 86,
            protein = 1.0,
            carbs = 20.0,
            fat = 0.0
        ),
        MealIngredient(
            nameResId = R.string.food_oatmeal,
            quantity = 100,
            unit = "g",
            calories = 389,
            protein = 16.0,
            carbs = 66.0,
            fat = 7.0
        ),
        MealIngredient(
            nameResId = R.string.food_quinoa,
            quantity = 100,
            unit = "g",
            calories = 120,
            protein = 4.0,
            carbs = 21.0,
            fat = 2.0
        ),
        MealIngredient(
            nameResId = R.string.food_banana,
            quantity = 1,
            unit = "piece",
            calories = 89,
            protein = 1.0,
            carbs = 23.0,
            fat = 0.0
        )
    )

    // Fat Sources
    val fatSources = listOf(
        MealIngredient(
            nameResId = R.string.food_avocado,
            quantity = 100,
            unit = "g",
            calories = 160,
            protein = 2.0,
            carbs = 8.0,
            fat = 15.0
        ),
        MealIngredient(
            nameResId = R.string.food_olive_oil,
            quantity = 15,
            unit = "ml",
            calories = 120,
            protein = 0.0,
            carbs = 0.0,
            fat = 14.0
        ),
        MealIngredient(
            nameResId = R.string.food_almonds,
            quantity = 100,
            unit = "g",
            calories = 579,
            protein = 21.0,
            carbs = 22.0,
            fat = 50.0
        ),
        MealIngredient(
            nameResId = R.string.food_peanut_butter,
            quantity = 32,
            unit = "g",
            calories = 190,
            protein = 8.0,
            carbs = 7.0,
            fat = 16.0
        ),
        MealIngredient(
            nameResId = R.string.food_cheese,
            quantity = 100,
            unit = "g",
            calories = 402,
            protein = 25.0,
            carbs = 1.0,
            fat = 33.0
        )
    )
} 