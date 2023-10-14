package com.application.tvizy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.item_tab.view.*

class StreamAdapter : RecyclerView.Adapter<StreamAdapter.ViewHolder>() {

    private lateinit var context: Context

    val selection = MutableLiveData<Int>()
    private var selected = 0

    private var titles = arrayOf(
        "Şu anda ne var?",
        "06:00",
        "08:00",
        "10:00",
        "12:00",
        "14:00",
        "16:00",
        "18:00"
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StreamAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_stream, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: StreamAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            tvTab.text = titles[position]


            /*setOnClickListener {
                (context as AppCompatActivity).rvTab.smoothScrollToPosition(position)
                selected = holder.adapterPosition

                if (selected == position) {
                    tvTab.background = ContextCompat.getDrawable(context, R.drawable.round_12_light_purple)
                    tvTab.setTextColor(ContextCompat.getColor(context, R.color.white))
                    notifyDataSetChanged()
                }
            }*/


            if (selected == position) {
                tvTab.setTextColor(ContextCompat.getColor(context, R.color.white))
                tvTab.background = ContextCompat.getDrawable(context, R.drawable.round_12_light_purple)
                (context as AppCompatActivity).rvTab.smoothScrollToPosition(position)
                selection.value = selected
            } else {
                tvTab.setTextColor(ContextCompat.getColor(context, R.color.black))
                tvTab.background = ContextCompat.getDrawable(context, R.drawable.round_12_white)
            }

            tvTab.setOnClickListener {
                selected = holder.adapterPosition
                notifyDataSetChanged()
            }

        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
