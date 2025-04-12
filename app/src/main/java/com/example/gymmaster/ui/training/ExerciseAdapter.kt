package com.example.gymmaster.ui.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymmaster.R
import com.example.gymmaster.data.models.Exercise

class ExerciseAdapter(
    private val exercises: List<Exercise>,
    private val onExerciseClick: (Exercise) -> Unit
) : RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.exerciseImage)
        val name: TextView = view.findViewById(R.id.exerciseName)
        val sets: TextView = view.findViewById(R.id.exerciseSets)
        val reps: TextView = view.findViewById(R.id.exerciseReps)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exercises[position]
        val context = holder.itemView.context

//        holder.image.setImageResource(exercise.imageResId)
        Glide.with(holder.itemView.context)
            .load(exercise.imageResId)
            .into(holder.image)

        holder.name.setText(exercise.nameResId)
        holder.sets.text = context.getString(R.string.exercise_sets, exercise.sets)
        holder.reps.text = context.getString(R.string.exercise_reps, exercise.reps)
        
        holder.itemView.setOnClickListener { onExerciseClick(exercise) }
    }

    override fun getItemCount() = exercises.size
} 