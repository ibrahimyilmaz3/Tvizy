package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.ui.activity.ProgramActivity
import kotlinx.android.synthetic.main.item_programs.view.*

class ProgramsAdapter : RecyclerView.Adapter<ProgramsAdapter.ViewHolder>() {

    private var program = arrayOf(
        R.drawable.example_program,
        R.drawable.example_program_2,
        R.drawable.example_program_3,
        R.drawable.example_program_4,
        R.drawable.example_program_5,
        R.drawable.example_program,
        R.drawable.example_program_2,
        R.drawable.example_program_3,
        R.drawable.example_program_4,
        R.drawable.example_program_5,
        R.drawable.example_program_2
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProgramsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_programs, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProgramsAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivSeries.setImageDrawable(ContextCompat.getDrawable(context, program[position]))

            setOnClickListener {
                val intent = Intent(context, ProgramActivity::class.java)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return program.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
