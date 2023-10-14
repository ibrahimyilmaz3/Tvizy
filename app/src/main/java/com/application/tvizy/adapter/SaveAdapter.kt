package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Save
import com.application.tvizy.ui.activity.ProgramActivity
import kotlinx.android.synthetic.main.item_save.view.*

class SaveAdapter(private val imagesArrayList: ArrayList<Save>) :
    RecyclerView.Adapter<SaveAdapter.ViewHolder>() {

    private var program = arrayOf(
        Pair(R.drawable.example_series,"Güzel Günler"),
        Pair(R.drawable.example_series_2,"Adım Farah"),
        Pair(R.drawable.example_series_3,"Elif"),
        Pair(R.drawable.example_series_4,"Bir Peri Masalı"),
        Pair(R.drawable.example_series_5,"Canım Annem"),
        Pair(R.drawable.example_series,"Güzel Günler"),
        Pair(R.drawable.example_series_2,"Adım Farah"),
        Pair(R.drawable.example_series_3,"Elif"),
        Pair(R.drawable.example_series_4,"Bir Peri Masalı"),
        Pair(R.drawable.example_series_5,"Canım Annem"),
        Pair(R.drawable.example_series,"Güzel Günler"),
        Pair(R.drawable.example_series_2,"Adım Farah"),
        Pair(R.drawable.example_series_3,"Elif"),
        Pair(R.drawable.example_series_4,"Bir Peri Masalı"),
        Pair(R.drawable.example_series_5,"Canım Annem")
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SaveAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_save, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: SaveAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivSeries.setImageDrawable(ContextCompat.getDrawable(context, program[position].first))
            tvName.text = program[position].second
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
