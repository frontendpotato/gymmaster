package com.example.gymmaster.ui.training

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gymmaster.R
import com.example.gymmaster.data.SampleTrainingData
import com.example.gymmaster.data.models.Exercise
import com.example.gymmaster.data.models.Muscle
import com.google.android.material.button.MaterialButton

class ExerciseDetailsActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_EXERCISE_ID = "extra_exercise_id"
        private const val EXTRA_PROGRAM_ID = "extra_program_id"
        private const val EXTRA_SPLIT_ID = "extra_split_id"
        private const val EXTRA_MUSCLE = "extra_muscle"

        fun newIntent(context: Context, programId: String, splitId: String, exerciseId: String): Intent {
            return Intent(context, ExerciseDetailsActivity::class.java).apply {
                putExtra(EXTRA_PROGRAM_ID, programId)
                putExtra(EXTRA_SPLIT_ID, splitId)
                putExtra(EXTRA_EXERCISE_ID, exerciseId)
            }
        }

        fun newIntentForMuscle(context: Context, exerciseId: String, muscle: Muscle): Intent {
            return Intent(context, ExerciseDetailsActivity::class.java).apply {
                putExtra(EXTRA_EXERCISE_ID, exerciseId)
                putExtra(EXTRA_MUSCLE, muscle.name)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_details)

        val exercise = getExercise()
        setupViews(exercise)
    }

    private fun getExercise(): Exercise = intent.run {
        val exerciseId = getStringExtra(EXTRA_EXERCISE_ID)
            ?: throw IllegalArgumentException("Exercise ID not provided")

        if (hasExtra(EXTRA_MUSCLE)) {
            // Get exercise from muscle group
            val muscle = Muscle.valueOf(getStringExtra(EXTRA_MUSCLE)!!)
            return SampleTrainingData.getExercisesForMuscle(muscle).find { it.id == exerciseId }
                ?: throw IllegalArgumentException("Exercise not found in muscle group")
        } else {
            // Get exercise from program/split
            val programId = getStringExtra(EXTRA_PROGRAM_ID)
            val splitId = getStringExtra(EXTRA_SPLIT_ID)

            val program = SampleTrainingData.programs.find { it.id == programId }
                ?: throw IllegalArgumentException("Program not found")
            
            val split = program.splits.find { it.id == splitId }
                ?: throw IllegalArgumentException("Split not found")
                
            return split.exercises.find { it.id == exerciseId }
                ?: throw IllegalArgumentException("Exercise not found")
        }
    }

    private fun setupViews(exercise: Exercise) {
        title = getString(exercise.nameResId)

        findViewById<ImageView>(R.id.exerciseGif).setImageResource(exercise.gifResId)
        findViewById<TextView>(R.id.exerciseDescription).setText(exercise.descriptionResId)
        
        findViewById<MaterialButton>(R.id.youtubeButton).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(exercise.youtubeLink)))
        }
    }
} 