package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Category
import com.application.tvizy.ui.activity.ChannelActivity
import kotlinx.android.synthetic.main.item_choose.view.*

class Choose2Adapter(val channel: ArrayList<Category>) :
    RecyclerView.Adapter<Choose2Adapter.ViewHolder>() {

    //private val list = ArrayList<Int>()

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Choose2Adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_choose, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Choose2Adapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivChannel.setImageDrawable(ContextCompat.getDrawable(context, channel[position].image))

            //if (list.contains(position)) ivTick.visibility = View.VISIBLE

            //Log.d("listValue", list.toString())

            /*if (list.contains(position)) ivTick.visibility = View.VISIBLE
            else ivTick.visibility = View.INVISIBLE*/

            when (position) {
                1, 3, 5, 6 -> ivTick.visibility = View.VISIBLE
                else -> {
                    ivTick.visibility = View.INVISIBLE
                }
            }

            setOnClickListener {
                /*if (list.contains(holder.adapterPosition)) list.remove(holder.adapterPosition)
                else list.add(holder.adapterPosition)*/
                val intent = Intent(context, ChannelActivity()::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return channel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
