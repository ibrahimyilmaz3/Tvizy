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
import com.application.tvizy.model.Channel
import com.application.tvizy.ui.activity.ChannelActivity
import kotlinx.android.synthetic.main.item_my_2.view.*

class ChannelFollowAdapter(private val imagesArrayList: ArrayList<Channel>) :
    RecyclerView.Adapter<ChannelFollowAdapter.ViewHolder>() {

    private var program = arrayOf(
        Triple(R.drawable.show_tv, "Show TV", "@showtv"),
        Triple(R.drawable.star_tv, "Star TV", "@startv"),
        Triple(R.drawable.atv, "ATV", "@atv"),
        Triple(R.drawable.kanal_d, "Kanal D", "@kanald"),
        Triple(R.drawable.show_tv, "Show TV", "@showtv"),
        Triple(R.drawable.star_tv, "Star TV", "@startv"),
        Triple(R.drawable.atv, "ATV", "@atv"),
        Triple(R.drawable.kanal_d, "Kanal D", "@kanald"),
        Triple(R.drawable.show_tv, "Show TV", "@showtv"),
        Triple(R.drawable.star_tv, "Star TV", "@startv"),
        Triple(R.drawable.atv, "ATV", "@atv"),
        Triple(R.drawable.kanal_d, "Kanal D", "@kanald")
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChannelFollowAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_my_2, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ChannelFollowAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivChannel.setImageDrawable(
                ContextCompat.getDrawable(
                    (context as AppCompatActivity),
                    program[position].first
                )
            )
            tvName.text = program[position].second
            tvUsername.text = program[position].third

            setOnClickListener {
                val intent = Intent(context, ChannelActivity()::class.java)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return program.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}