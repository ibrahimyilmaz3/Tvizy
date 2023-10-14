package com.application.tvizy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.item_tab.view.*

class TabAdapter : RecyclerView.Adapter<TabAdapter.ViewHolder>() {

    private lateinit var context: Context

    //val selection = MutableLiveData<Int>()
    private var selected = 0

    private var titles = arrayOf(
        "Favori Kanallarım",
        "Haber",
        "Çocuk",
        "Ulusal",
        "Ulusal",
        "Ulusal",
        "Ulusal",
        "Tematik"
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TabAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_tab, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: TabAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {

            tvTab.text = titles[position]

            setOnClickListener {
                (context as AppCompatActivity).rvTab.smoothScrollToPosition(position)
                selected = holder.absoluteAdapterPosition
                notifyDataSetChanged()
            }

            if (selected == position) {
                tvTab.setTextColor(ContextCompat.getColor(context, R.color.white))
                tvTab.background =
                    ContextCompat.getDrawable(context, R.drawable.round_12_light_purple)
                (context as AppCompatActivity).rvTab.smoothScrollToPosition(position)
            } else {
                tvTab.setTextColor(ContextCompat.getColor(context, R.color.black))
                tvTab.background = ContextCompat.getDrawable(context, R.drawable.round_12_white)
            }

        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
