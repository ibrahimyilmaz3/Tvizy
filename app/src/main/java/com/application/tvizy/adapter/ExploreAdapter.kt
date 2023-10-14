package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Explore
import com.application.tvizy.ui.activity.ProgramActivity
import kotlinx.android.synthetic.main.item_explore.view.*

class ExploreAdapter(private val image: ArrayList<Explore>) :
    RecyclerView.Adapter<ExploreAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExploreAdapter.ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_explore, parent, false)
        context = parent.context
        return ViewHolder(v)
    }
    
    override fun onBindViewHolder(holder: ExploreAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivFlex.setImageDrawable(ContextCompat.getDrawable(context, image[position].image))

            setOnClickListener {
                val intent = Intent(context, ProgramActivity::class.java)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return image.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
