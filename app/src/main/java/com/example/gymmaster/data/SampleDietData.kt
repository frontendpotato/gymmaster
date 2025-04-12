package com.example.gymmaster.data

import com.example.gymmaster.R
import com.example.gymmaster.data.models.DietProgram
import com.example.gymmaster.data.models.Food
import com.example.gymmaster.data.models.Meal
import com.example.gymmaster.data.models.NutritionCategory

object SampleDietData {
    
    // Diet Programs
    val dietPrograms = listOf(
        DietProgram(
            id = "bulking",
            nameResId = R.string.diet_bulking,
            descriptionResId = R.string.diet_bulking_description,
            imageResId = R.drawable.ic_diet,
            meals = listOf(
                Meal(
                    id = "bulking_breakfast",
                    nameResId = R.string.meal_bulking_breakfast,
                    descriptionResId = R.string.meal_bulking_breakfast_description,
                    imageResId = R.drawable.ic_diet,
                    calories = 650,
                    protein = 40,
                    carbs = 70,
                    fat = 20,
                    ingredients = listOf(
                        "4 eggs",
                        "1 cup oatmeal",
                        "1 banana",
                        "2 tbsp peanut butter",
                        "1 cup milk"
                    ),
                    instructions = listOf(
                        "Cook oatmeal with milk",
                        "Scramble eggs",
                        "Slice banana and add to oatmeal",
                        "Add peanut butter to oatmeal and mix"
                    )
                ),
                Meal(
                    id = "bulking_lunch",
                    nameResId = R.string.meal_bulking_lunch,
                    descriptionResId = R.string.meal_bulking_lunch_description,
                    imageResId = R.drawable.ic_diet,
                    calories = 800,
                    protein = 50,
                    carbs = 80,
                    fat = 25,
                    ingredients = listOf(
                        "8 oz chicken breast",
                        "1 cup brown rice",
                        "1 cup broccoli",
                        "1 tbsp olive oil",
                        "Spices to taste"
                    ),
                    instructions = listOf(
                        "Cook rice according to package",
                        "Season and grill chicken breast",
                        "Steam broccoli",
                        "Drizzle olive oil over meal"
                    )
                ),
                Meal(
                    id = "bulking_dinner",
                    nameResId = R.string.meal_bulking_dinner,
                    descriptionResId = R.string.meal_bulking_dinner_description,
                    imageResId = R.drawable.ic_diet,
                    calories = 750,
                    protein = 45,
                    carbs = 65,
                    fat = 30,
                    ingredients = listOf(
                        "8 oz salmon",
                        "1 large sweet potato",
                        "2 cups mixed vegetables",
                        "2 tbsp olive oil",
                        "Lemon and herbs"
                    ),
                    instructions = listOf(
                        "Bake salmon with lemon and herbs",
                        "Bake sweet potato",
                        "Roast vegetables with olive oil"
                    )
                )
            )
        ),
        DietProgram(
            id = "cutting",
            nameResId = R.string.diet_cutting,
            descriptionResId = R.string.diet_cutting_description,
            imageResId = R.drawable.ic_diet,
            meals = listOf(
                Meal(
                    id = "cutting_breakfast",
                    nameResId = R.string.meal_cutting_breakfast,
                    descriptionResId = R.string.meal_cutting_breakfast_description,
                    imageResId = R.drawable.ic_diet,
                    calories = 350,
                    protein = 30,
                    carbs = 30,
                    fat = 10,
                    ingredients = listOf(
                        "3 egg whites, 1 whole egg",
                        "1/2 cup oatmeal",
                        "1/2 cup berries"
                    ),
                    instructions = listOf(
                        "Cook egg whites and whole egg",
                        "Prepare oatmeal with water",
                        "Add berries to oatmeal"
                    )
                ),
                Meal(
                    id = "cutting_lunch",
                    nameResId = R.string.meal_cutting_lunch,
                    descriptionResId = R.string.meal_cutting_lunch_description,
                    imageResId = R.drawable.ic_diet,
                    calories = 400,
                    protein = 40,
                    carbs = 30,
                    fat = 10,
                    ingredients = listOf(
                        "6 oz chicken breast",
                        "2 cups salad greens",
                        "1/2 cup quinoa",
                        "1 tbsp olive oil and vinegar"
                    ),
                    instructions = listOf(
                        "Grill chicken breast",
                        "Cook quinoa",
                        "Mix salad with olive oil and vinegar",
                        "Combine all ingredients"
                    )
                ),
                Meal(
                    id = "cutting_dinner",
                    nameResId = R.string.meal_cutting_dinner,
                    descriptionResId = R.string.meal_cutting_dinner_description,
                    imageResId = R.drawable.ic_diet,
                    calories = 350,
                    protein = 35,
                    carbs = 20,
                    fat = 15,
                    ingredients = listOf(
                        "5 oz white fish",
                        "1 cup steamed vegetables",
                        "1/2 avocado",
                        "Lemon and herbs"
                    ),
                    instructions = listOf(
                        "Steam or bake fish with lemon and herbs",
                        "Steam vegetables",
                        "Slice avocado for serving"
                    )
                )
            )
        ),
        DietProgram(
            id = "maintenance",
            nameResId = R.string.diet_maintenance,
            descriptionResId = R.string.diet_maintenance_description,
            imageResId = R.drawable.ic_diet,
            meals = listOf(
                // Add maintenance meals here
            )
        )
    )
    
    // Nutrition Categories - Separate list
    val nutritionCategories = listOf(
        NutritionCategory(
            id = "protein",
            nameResId = R.string.nutrition_protein,
            descriptionResId = R.string.nutrition_protein_description,
            imageResId = R.drawable.ic_diet,
            foods = listOf(
                Food(
                    id = "chicken_breast",
                    nameResId = R.string.food_chicken_breast,
                    calories = 165,
                    protein = 31,
                    carbs = 0,
                    fat = 3,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "eggs",
                    nameResId = R.string.food_eggs,
                    calories = 70,
                    protein = 6,
                    carbs = 0,
                    fat = 5,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "greek_yogurt",
                    nameResId = R.string.food_greek_yogurt,
                    calories = 100,
                    protein = 17,
                    carbs = 6,
                    fat = 0,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "salmon",
                    nameResId = R.string.food_salmon,
                    calories = 206,
                    protein = 22,
                    carbs = 0,
                    fat = 13,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "whey_protein",
                    nameResId = R.string.food_whey_protein,
                    calories = 120,
                    protein = 24,
                    carbs = 3,
                    fat = 2,
                    imageResId = R.drawable.ic_diet
                )
            )
        ),
        NutritionCategory(
            id = "carbs",
            nameResId = R.string.nutrition_carbs,
            descriptionResId = R.string.nutrition_carbs_description,
            imageResId = R.drawable.ic_training,
            foods = listOf(
                Food(
                    id = "brown_rice",
                    nameResId = R.string.food_brown_rice,
                    calories = 216,
                    protein = 5,
                    carbs = 45,
                    fat = 2,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "sweet_potato",
                    nameResId = R.string.food_sweet_potato,
                    calories = 112,
                    protein = 2,
                    carbs = 26,
                    fat = 0,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "oatmeal",
                    nameResId = R.string.food_oatmeal,
                    calories = 150,
                    protein = 5,
                    carbs = 27,
                    fat = 3,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "quinoa",
                    nameResId = R.string.food_quinoa,
                    calories = 222,
                    protein = 8,
                    carbs = 39,
                    fat = 4,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "banana",
                    nameResId = R.string.food_banana,
                    calories = 105,
                    protein = 1,
                    carbs = 27,
                    fat = 0,
                    imageResId = R.drawable.ic_diet
                )
            )
        ),
        NutritionCategory(
            id = "fats",
            nameResId = R.string.nutrition_fats,
            descriptionResId = R.string.nutrition_fats_description,
            imageResId = R.drawable.ic_settings,
            foods = listOf(
                Food(
                    id = "avocado",
                    nameResId = R.string.food_avocado,
                    calories = 240,
                    protein = 3,
                    carbs = 12,
                    fat = 22,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "olive_oil",
                    nameResId = R.string.food_olive_oil,
                    calories = 120,
                    protein = 0,
                    carbs = 0,
                    fat = 14,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "almonds",
                    nameResId = R.string.food_almonds,
                    calories = 164,
                    protein = 6,
                    carbs = 6,
                    fat = 14,
                    imageResId = R.drawable.ic_home
                ),
                Food(
                    id = "peanut_butter",
                    nameResId = R.string.food_peanut_butter,
                    calories = 190,
                    protein = 8,
                    carbs = 7,
                    fat = 16,
                    imageResId = R.drawable.ic_diet
                ),
                Food(
                    id = "cheese",
                    nameResId = R.string.food_cheese,
                    calories = 113,
                    protein = 7,
                    carbs = 1,
                    fat = 9,
                    imageResId = R.drawable.ic_diet
                )
            )
        )
    )
} 