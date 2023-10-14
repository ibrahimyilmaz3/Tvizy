package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Search
import com.application.tvizy.ui.activity.ChannelActivity
import com.application.tvizy.ui.activity.FollowingActivity
import kotlinx.android.synthetic.main.item_focus.view.*

class FocusAdapter(private val search: ArrayList<Search>) :
    RecyclerView.Adapter<FocusAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FocusAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_focus, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: FocusAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivChannel.setImageDrawable(ContextCompat.getDrawable(context, search[position].image))
            tvName.text = search[position].name
            tvUsername.text = search[position].username

            ivCross.setOnClickListener {
                search.removeAt(holder.adapterPosition)
                notifyDataSetChanged()
            }

            setOnClickListener {
                when (search[position].name) {
                    "Show TV", "Star TV", "ATV", "Kanal D" -> {
                        val intent = Intent(context, ChannelActivity::class.java)
                        context.startActivity(intent)
                    }
                    else -> {
                        val intent = Intent(context, FollowingActivity::class.java)
                        context.startActivity(intent)
                    }
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return search.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
