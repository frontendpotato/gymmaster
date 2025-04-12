package com.example.gymmaster.ui.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymmaster.R
import com.example.gymmaster.data.models.Program

class ProgramAdapter(
    private val programs: List<Program>,
    private val onProgramClick: (Program) -> Unit
) : RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder>() {

    class ProgramViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.programImage)
        val name: TextView = view.findViewById(R.id.programName)
        val duration: TextView = view.findViewById(R.id.programDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_program_card, parent, false)
        return ProgramViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        val program = programs[position]
       // holder.image.setImageResource(program.imageResId)

        Glide.with(holder.itemView.context)
            .load(program.imageResId)
            .into(holder.image)

        holder.name.setText(program.nameResId)
        holder.duration.text = holder.itemView.context.getString(
            R.string.program_duration_weeks, 
            program.durationWeeks
        )
        holder.itemView.setOnClickListener { onProgramClick(program) }
    }

    override fun getItemCount() = programs.size
} 