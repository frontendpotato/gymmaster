package com.example.gymmaster.ui.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymmaster.R
import com.example.gymmaster.data.models.Muscle

class MuscleAdapter(
    private val muscles: List<Muscle>,
    private val onMuscleClick: (Muscle) -> Unit
) : RecyclerView.Adapter<MuscleAdapter.MuscleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuscleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_muscle_card, parent, false)
        return MuscleViewHolder(view)
    }

    override fun onBindViewHolder(holder: MuscleViewHolder, position: Int) {
        holder.bind(muscles[position])
    }

    override fun getItemCount() = muscles.size

    inner class MuscleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val muscleImage: ImageView = itemView.findViewById(R.id.muscleImage)
        private val muscleName: TextView = itemView.findViewById(R.id.muscleName)

        fun bind(muscle: Muscle) {
//            muscleImage.setImageResource(getMuscleImage(muscle))

                Glide.with(itemView.context)
                    .load(getMuscleImage(muscle))
                    .centerCrop()
                    .into(muscleImage)

                muscleName.setText(getMuscleName(muscle))
                itemView.setOnClickListener { onMuscleClick(muscle) }


            muscleName.setText(getMuscleName(muscle))
            itemView.setOnClickListener { onMuscleClick(muscle) }
        }

        private fun getMuscleImage(muscle: Muscle): Int {
            return when (muscle) {
                Muscle.CHEST -> R.drawable.ic_diet
                Muscle.BACK -> R.drawable.ic_training
                Muscle.SHOULDERS -> R.drawable.ic_diet
                Muscle.BICEPS -> R.drawable.ic_settings
                Muscle.TRICEPS -> R.drawable.ic_settings
                Muscle.LEGS -> R.drawable.ic_training
                Muscle.ABS -> R.drawable.ic_diet
                Muscle.NONE -> R.drawable.ic_training
            }
        }

        private fun getMuscleName(muscle: Muscle): Int {
            return when (muscle) {
                Muscle.CHEST -> R.string.muscle_chest
                Muscle.BACK -> R.string.muscle_back
                Muscle.SHOULDERS -> R.string.muscle_shoulders
                Muscle.BICEPS -> R.string.muscle_biceps
                Muscle.TRICEPS -> R.string.muscle_triceps
                Muscle.LEGS -> R.string.muscle_legs
                Muscle.ABS -> R.string.muscle_abs
                Muscle.NONE -> R.string.muscle_none
            }
        }
    }
}