package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.ui.activity.StoryActivity
import kotlinx.android.synthetic.main.item_story1.view.*

class StoryAdapter : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    private val arrayStory = arrayListOf(
        Triple(R.drawable.tvizy_icon, R.drawable.tvizy_text_square, false),
        Triple(R.drawable.show_tv, R.drawable.example_series_3, true),
        Triple(R.drawable.star_tv, R.drawable.example_series_2, true),
        Triple(R.drawable.atv, R.drawable.example_series, false),
        Triple(R.drawable.kanald_logo, R.drawable.example_series_4, false)
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_story1, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: StoryAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {

/*
            if(position == 1 || position == 2) mainCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.light_purple))
            else mainCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color_F5F5F5))
*/

            ivChannel.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    arrayStory[position].first
                )
            )

            ivProgram.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    arrayStory[position].second
                )
            )

            if (arrayStory[position].third) ivLive.visibility =
                View.VISIBLE else ivLive.visibility = View.GONE

            setOnClickListener {
                val intent = Intent(context as AppCompatActivity, StoryActivity::class.java)
                intent.putExtra("channel", holder.absoluteAdapterPosition)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return arrayStory.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
