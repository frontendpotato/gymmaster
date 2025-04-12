package com.example.gymmaster.ui.diet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymmaster.R
import com.example.gymmaster.data.models.DietProgram

class DietProgramAdapter(
    private val dietPrograms: List<DietProgram>,
    private val onDietProgramClick: (DietProgram) -> Unit
) : RecyclerView.Adapter<DietProgramAdapter.DietProgramViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietProgramViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_diet_program, parent, false)
        return DietProgramViewHolder(view)
    }

    override fun onBindViewHolder(holder: DietProgramViewHolder, position: Int) {
        holder.bind(dietPrograms[position])
    }

    override fun getItemCount() = dietPrograms.size

    inner class DietProgramViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dietProgramImage: ImageView = itemView.findViewById(R.id.dietProgramImage)
        private val dietProgramName: TextView = itemView.findViewById(R.id.dietProgramName)
        private val dietProgramDescription: TextView = itemView.findViewById(R.id.dietProgramDescription)

        fun bind(dietProgram: DietProgram) {
            Glide.with(itemView.context)
                .load(dietProgram.imageResId)
                .centerCrop()
                .into(dietProgramImage)
                
            dietProgramName.setText(dietProgram.nameResId)
            dietProgramDescription.setText(dietProgram.descriptionResId)
            
            itemView.setOnClickListener { onDietProgramClick(dietProgram) }
        }
    }
} 