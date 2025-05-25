package com.example.gymmaster.ui.diet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.NutritionData
//import com.example.gymmaster.data.models.DietProgram
import com.example.gymmaster.data.models.NutritionCategory
//import com.example.gymmaster.data.models.Day
import com.example.gymmaster.data.models.Meal
import com.example.gymmaster.data.models.MealIngredient

class DietFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setupDietProgramsRecyclerView(view)
        setupNutritionCategoriesRecyclerView(view)
    }

/*    private fun setupDietProgramsRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.dietProgramsRecyclerView)
        
        // Create sample diet programs with days and meals
        val dietPrograms = listOf(
            DietProgram(
                id = "bulking",
                nameResId = R.string.diet_bulking,
                descriptionResId = R.string.diet_bulking_description,
                imageResId = R.drawable.ic_diet,
                days = listOf(
                    Day(
                        id = "day1",
                        nameResId = R.string.day_1,
                        meals = listOf(
                            Meal(
                                id = "breakfast",
                                nameResId = R.string.meal_breakfast,
                                ingredients = listOf(
                                    MealIngredient(
                                        nameResId = R.string.ingredient_oatmeal,
                                        quantity = 100,
                                        unit = "g",
                                        calories = 389,
                                        protein = 13.0,
                                        carbs = 66.0,
                                        fat = 7.0
                                    ),
                                    MealIngredient(
                                        nameResId = R.string.ingredient_banana,
                                        quantity = 1,
                                        unit = "piece",
                                        calories = 105,
                                        protein = 1.3,
                                        carbs = 27.0,
                                        fat = 0.3
                                    )
                                ),
                                mainResource = "carbs"
                            ),
                            Meal(
                                id = "lunch",
                                nameResId = R.string.meal_lunch,
                                ingredients = listOf(
                                    MealIngredient(
                                        nameResId = R.string.ingredient_chicken_breast,
                                        quantity = 200,
                                        unit = "g",
                                        calories = 330,
                                        protein = 62.0,
                                        carbs = 0.0,
                                        fat = 7.2
                                    ),
                                    MealIngredient(
                                        nameResId = R.string.ingredient_brown_rice,
                                        quantity = 150,
                                        unit = "g",
                                        calories = 216,
                                        protein = 4.5,
                                        carbs = 45.0,
                                        fat = 1.8
                                    )
                                ),
                                mainResource = "protein"
                            )
                        )
                    )
                )
            ),
            DietProgram(
                id = "cutting",
                nameResId = R.string.diet_cutting,
                descriptionResId = R.string.diet_cutting_description,
                imageResId = R.drawable.ic_diet,
                days = listOf(
                    Day(
                        id = "day1",
                        nameResId = R.string.day_1,
                        meals = listOf(
                            Meal(
                                id = "breakfast",
                                nameResId = R.string.meal_breakfast,
                                ingredients = listOf(
                                    MealIngredient(
                                        nameResId = R.string.ingredient_egg_whites,
                                        quantity = 6,
                                        unit = "pieces",
                                        calories = 102,
                                        protein = 21.0,
                                        carbs = 1.2,
                                        fat = 0.2
                                    ),
                                    MealIngredient(
                                        nameResId = R.string.ingredient_spinach,
                                        quantity = 100,
                                        unit = "g",
                                        calories = 23,
                                        protein = 2.9,
                                        carbs = 3.6,
                                        fat = 0.4
                                    )
                                ),
                                mainResource = "protein"
                            ),
                            Meal(
                                id = "lunch",
                                nameResId = R.string.meal_lunch,
                                ingredients = listOf(
                                    MealIngredient(
                                        nameResId = R.string.ingredient_turkey_breast,
                                        quantity = 150,
                                        unit = "g",
                                        calories = 165,
                                        protein = 31.5,
                                        carbs = 0.0,
                                        fat = 3.6
                                    ),
                                    MealIngredient(
                                        nameResId = R.string.ingredient_sweet_potato,
                                        quantity = 100,
                                        unit = "g",
                                        calories = 86,
                                        protein = 1.6,
                                        carbs = 20.0,
                                        fat = 0.1
                                    )
                                ),
                                mainResource = "protein"
                            )
                        )
                    )
                )
            ),
            DietProgram(
                id = "maintenance",
                nameResId = R.string.diet_maintenance,
                descriptionResId = R.string.diet_maintenance_description,
                imageResId = R.drawable.ic_diet,
                days = listOf(
                    Day(
                        id = "day1",
                        nameResId = R.string.day_1,
                        meals = listOf(
                            Meal(
                                id = "breakfast",
                                nameResId = R.string.meal_breakfast,
                                ingredients = listOf(
                                    MealIngredient(
                                        nameResId = R.string.ingredient_greek_yogurt,
                                        quantity = 200,
                                        unit = "g",
                                        calories = 130,
                                        protein = 20.0,
                                        carbs = 9.0,
                                        fat = 0.7
                                    ),
                                    MealIngredient(
                                        nameResId = R.string.ingredient_berries,
                                        quantity = 100,
                                        unit = "g",
                                        calories = 57,
                                        protein = 0.7,
                                        carbs = 14.0,
                                        fat = 0.3
                                    )
                                ),
                                mainResource = "protein"
                            ),
                            Meal(
                                id = "lunch",
                                nameResId = R.string.meal_lunch,
                                ingredients = listOf(
                                    MealIngredient(
                                        nameResId = R.string.ingredient_salmon,
                                        quantity = 150,
                                        unit = "g",
                                        calories = 208,
                                        protein = 22.0,
                                        carbs = 0.0,
                                        fat = 13.0
                                    ),
                                    MealIngredient(
                                        nameResId = R.string.ingredient_quinoa,
                                        quantity = 100,
                                        unit = "g",
                                        calories = 120,
                                        protein = 4.4,
                                        carbs = 21.0,
                                        fat = 1.9
                                    )
                                ),
                                mainResource = "protein"
                            )
                        )
                    )
                )
            )
        )
        
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        
        val adapter = DietProgramAdapter(dietPrograms) { dietProgram ->
            // Navigate to diet program details
            val intent = Intent(requireContext(), DietDetailsActivity::class.java)
            intent.putExtra("diet_program", dietProgram)
            startActivity(intent)
        }
        
        recyclerView.adapter = adapter
    }*/

    private fun setupNutritionCategoriesRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.nutritionCategoriesRecyclerView)
        
        // Create nutrition categories with their respective ingredients
        val nutritionCategories = listOf(
            NutritionCategory(
                id = "protein",
                nameResId = R.string.nutrition_protein,
                descriptionResId = R.string.nutrition_protein_description,
                imageResId = R.drawable.ic_diet,
                ingredients = NutritionData.proteinSources
            ),
            NutritionCategory(
                id = "carbs",
                nameResId = R.string.nutrition_carbs,
                descriptionResId = R.string.nutrition_carbs_description,
                imageResId = R.drawable.ic_diet,
                ingredients = NutritionData.carbSources
            ),
            NutritionCategory(
                id = "fats",
                nameResId = R.string.nutrition_fats,
                descriptionResId = R.string.nutrition_fats_description,
                imageResId = R.drawable.ic_diet,
                ingredients = NutritionData.fatSources
            )
        )
        
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        
        val adapter = NutritionCategoryAdapter(nutritionCategories) { nutritionCategory ->
            // Navigate to nutrition category details
            val intent = Intent(requireContext(), NutritionDetailsActivity::class.java)
            intent.putExtra("nutrition_category", nutritionCategory)
            startActivity(intent)
        }
        
        recyclerView.adapter = adapter
    }
} 