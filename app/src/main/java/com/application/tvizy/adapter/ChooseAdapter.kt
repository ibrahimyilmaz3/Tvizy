package com.application.tvizy.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Category
import kotlinx.android.synthetic.main.item_choose.view.*

@Deprecated("Removed from design")
class ChooseAdapter(val channel: ArrayList<Category>) : RecyclerView.Adapter<ChooseAdapter.ViewHolder>() {

    private val list = ArrayList<Int>()

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChooseAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_choose, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ChooseAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivChannel.setImageDrawable(ContextCompat.getDrawable(context, channel[position].image))

            if (list.contains(position)) ivTick.visibility = View.VISIBLE

            Log.d("listValue", list.toString())

            if (list.contains(position)) ivTick.visibility = View.VISIBLE
            else ivTick.visibility = View.INVISIBLE

            setOnClickListener {
                if (list.contains(holder.adapterPosition)) list.remove(holder.adapterPosition)
                else list.add(holder.adapterPosition)
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return channel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
