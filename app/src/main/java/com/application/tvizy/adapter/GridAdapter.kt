package com.application.tvizy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Grid
import kotlinx.android.synthetic.main.item_grid.view.*

class GridAdapter(private val imagesArrayList: ArrayList<Grid>) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    private var program = arrayOf(
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_series
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: GridAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivGrid.setImageDrawable(ContextCompat.getDrawable(context, program[position]))
        }
    }

    override fun getItemCount(): Int {
        return program.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}