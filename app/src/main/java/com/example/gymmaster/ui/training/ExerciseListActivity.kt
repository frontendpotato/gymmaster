package com.example.gymmaster.ui.training

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.SampleTrainingData
import com.example.gymmaster.data.models.Exercise
import com.example.gymmaster.data.models.Muscle
import com.example.gymmaster.data.models.Split

class ExerciseListActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_SPLIT_ID = "extra_split_id"
        private const val EXTRA_PROGRAM_ID = "extra_program_id"
        private const val EXTRA_MUSCLE = "extra_muscle"

        fun newIntent(context: Context, programId: String, splitId: String): Intent {
            return Intent(context, ExerciseListActivity::class.java).apply {
                putExtra(EXTRA_PROGRAM_ID, programId)
                putExtra(EXTRA_SPLIT_ID, splitId)
            }
        }

        fun newIntent(context: Context, muscle: Muscle): Intent {
            return Intent(context, ExerciseListActivity::class.java).apply {
                putExtra(EXTRA_MUSCLE, muscle.name)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_list)

        val exercises = if (intent.hasExtra(EXTRA_MUSCLE)) {
            getMuscleExercises()
        } else {
            getSplit().exercises
        }
        
        setupViews(exercises)
    }

    private fun getMuscleExercises(): List<Exercise> {
        val muscle = Muscle.valueOf(intent.getStringExtra(EXTRA_MUSCLE)!!)
        title = getString(getMuscleTitleRes(muscle))
        return SampleTrainingData.getExercisesForMuscle(muscle)
    }

    private fun getMuscleTitleRes(muscle: Muscle): Int {
        return when (muscle) {
            Muscle.CHEST -> R.string.muscle_chest
            Muscle.BACK -> R.string.muscle_back
            Muscle.SHOULDERS -> R.string.muscle_shoulders
            Muscle.BICEPS -> R.string.muscle_biceps
            Muscle.TRICEPS -> R.string.muscle_triceps
            Muscle.LEGS -> R.string.muscle_legs
            Muscle.ABS -> R.string.muscle_abs
            Muscle.NONE -> TODO()
        }
    }

    private fun getSplit(): Split {
        val programId = intent.getStringExtra(EXTRA_PROGRAM_ID)
        val splitId = intent.getStringExtra(EXTRA_SPLIT_ID)
        
        val program = SampleTrainingData.programs.find { it.id == programId }
            ?: throw IllegalArgumentException("Program not found")
            
        return program.splits.find { it.id == splitId }
            ?: throw IllegalArgumentException("Split not found")
    }

    private fun setupViews(exercises: List<Exercise>) {
        val recyclerView = findViewById<RecyclerView>(R.id.exercisesRecyclerView)
        val adapter = ExerciseAdapter(exercises) { exercise ->
            if (intent.hasExtra(EXTRA_MUSCLE)) {
                val muscle = Muscle.valueOf(intent.getStringExtra(EXTRA_MUSCLE)!!)
                startActivity(
                    ExerciseDetailsActivity.newIntentForMuscle(this, exercise.id, muscle)
                )
            } else {
                startActivity(
                    ExerciseDetailsActivity.newIntent(
                        this,
                        intent.getStringExtra(EXTRA_PROGRAM_ID)!!,
                        getSplit().id,
                        exercise.id
                    )
                )
            }
        }
        recyclerView.adapter = adapter
    }
}