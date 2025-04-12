package com.example.gymmaster.ui.training

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.data.SampleTrainingData
import com.example.gymmaster.data.models.Muscle

class TrainingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_training, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.programsRecyclerView)
        val adapter = ProgramAdapter(SampleTrainingData.programs) { program ->
            // Launch program details activity
            startActivity(ProgramDetailsActivity.newIntent(requireContext(), program.id))
        }
        recyclerView.adapter = adapter

        val musclesRecyclerView = view.findViewById<RecyclerView>(R.id.musclesRecyclerView)
        val muscleAdapter = MuscleAdapter(Muscle.values().toList()) { muscle ->
            startActivity(
                ExerciseListActivity.newIntent(
                    requireContext(),
                    muscle
                )
            )
        }
        musclesRecyclerView.adapter = muscleAdapter
    }
} 