package com.example.gymmaster.data.models

data class Program(
    val id: String,
    val nameResId: Int,  // String resource ID for localization
    val imageResId: Int, // Drawable resource ID
    val durationWeeks: Int,
    val splits: List<Split>
)

data class Split(
    val id: String,
    val dayNumber: Int,
    val isRest: Boolean = false,
    val durationMinutes: Int = 0,
    val targetedMuscles: List<Muscle> = emptyList(),
    val exercises: List<Exercise> = emptyList()
)

data class Exercise(
    val id: String,
    val nameResId: Int,  // String resource ID for localization
    val descriptionResId: Int,  // String resource ID for localization
    val imageResId: Int, // Drawable resource ID
    val youtubeLink: String,
    val targetMuscle: Muscle,
    val sets: Int,
    val reps: String,  // Can be "12-15" or "Until failure"
    val restSeconds: Int,
    val gifResId: Int
)

enum class Muscle {
    CHEST, BACK, SHOULDERS, BICEPS, TRICEPS, LEGS, ABS, NONE
} 