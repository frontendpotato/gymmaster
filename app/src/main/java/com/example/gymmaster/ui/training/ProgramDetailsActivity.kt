package com.example.gymmaster.ui.training

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.SampleTrainingData
import com.example.gymmaster.data.models.Program

class ProgramDetailsActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_PROGRAM_ID = "extra_program_id"

        fun newIntent(context: Context, programId: String): Intent {
            return Intent(context, ProgramDetailsActivity::class.java).apply {
                putExtra(EXTRA_PROGRAM_ID, programId)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program_details)

        val programId = intent.getStringExtra(EXTRA_PROGRAM_ID)
        val program = SampleTrainingData.programs.find { it.id == programId }
            ?: throw IllegalArgumentException("Program not found")

        setupViews(program)
    }

    private fun setupViews(program: Program) {
        title = getString(program.nameResId)
        
        val splitsRecyclerView = findViewById<RecyclerView>(R.id.splitsRecyclerView)
        val adapter = SplitAdapter(program.splits) { split ->
            if (!split.isRest) {
                startActivity(ExerciseListActivity.newIntent(this, program.id, split.id))
            }
        }
        splitsRecyclerView.adapter = adapter
    }
} 