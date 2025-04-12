package com.example.gymmaster.ui.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymmaster.R
import com.example.gymmaster.data.SampleTrainingData
import com.example.gymmaster.data.models.Split

class SplitAdapter(
    private val splits: List<Split>,
    private val onSplitClick: (Split) -> Unit
) : RecyclerView.Adapter<SplitAdapter.SplitViewHolder>() {

    class SplitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val muscleImage: ImageView = view.findViewById(R.id.muscleImage)
        val dayNumber: TextView = view.findViewById(R.id.dayNumber)
        val duration: TextView = view.findViewById(R.id.duration)
        val exerciseCount: TextView = view.findViewById(R.id.exerciseCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SplitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_split_card, parent, false)
        return SplitViewHolder(view)
    }

    override fun onBindViewHolder(holder: SplitViewHolder, position: Int) {
        val split = splits[position]
        val context = holder.itemView.context

        if (split.isRest) {
            holder.dayNumber.setText(R.string.day_rest)
            holder.duration.visibility = View.GONE
            holder.exerciseCount.visibility = View.GONE
            //holder.muscleImage.setImageResource(R.drawable.ic_training)

            Glide.with(holder.itemView.context)
                .load(R.drawable.ic_training)
                .into(holder.muscleImage)

        } else {
            holder.dayNumber.text = context.getString(R.string.day_number, split.dayNumber)
            holder.duration.text = context.getString(R.string.day_duration, split.durationMinutes)
            holder.exerciseCount.text = context.getString(R.string.day_exercises, split.exercises.size)
            holder.duration.visibility = View.VISIBLE
            holder.exerciseCount.visibility = View.VISIBLE
            //holder.muscleImage.setImageResource(SampleTrainingData.getMuscleImageResource(split.targetedMuscles))
            Glide.with(holder.itemView.context)
                .load(SampleTrainingData.getMuscleImageResource(split.targetedMuscles))
                .into(holder.muscleImage)


            holder.itemView.setOnClickListener { onSplitClick(split) }
        }
    }

    override fun getItemCount() = splits.size
} 