package com.application.tvizy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import kotlinx.android.synthetic.main.item_streams.view.*

class StreamsAdapter : RecyclerView.Adapter<StreamsAdapter.ViewHolder>() {

    val arrayList = arrayListOf(
        Triple("08:00", R.drawable.example_series, "Sabah Haberleri"),
        Triple("12:00", R.drawable.example_series_2, "Müge Anlı ile Tatlı Sert"),
        Triple("17:00", R.drawable.example_series_3, "Gün Ortası"),
        Triple("20:00", R.drawable.example_series_4, "Sipahi"),
        Triple("23:00", R.drawable.example_series_5, "Sipahi Tekrar"),
        Triple("08:00", R.drawable.example_series, "Sabah Haberleri"),
        Triple("12:00", R.drawable.example_series_2, "Müge Anlı ile Tatlı Sert"),
        Triple("17:00", R.drawable.example_series_3, "Gün Ortası"),
        Triple("20:00", R.drawable.example_series_4, "Sipahi"),
        Triple("23:00", R.drawable.example_series_5, "Sipahi Tekrar"),
        Triple("08:00", R.drawable.example_series, "Sabah Haberleri"),
        Triple("12:00", R.drawable.example_series_2, "Müge Anlı ile Tatlı Sert"),
        Triple("17:00", R.drawable.example_series_3, "Gün Ortası"),
        Triple("20:00", R.drawable.example_series_4, "Sipahi"),
        Triple("23:00", R.drawable.example_series_5, "Sipahi Tekrar")
    )

    private lateinit var context: Context
    private var selected = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StreamsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_streams, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: StreamsAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {

            conPicture.visibility = View.GONE

            tvHour.text = arrayList[position].first
            ivPicture.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    arrayList[position].second
                )
            )
            tvName.text = arrayList[position].third
            ivClock.setColorFilter(ContextCompat.getColor(context, R.color.black))

            if (selected == position) {
                conPicture.visibility = View.VISIBLE
                linearHour.background =
                    ContextCompat.getDrawable(context, R.drawable.round_12_light_purple)
                tvHour.setTextColor(ContextCompat.getColor(context, R.color.white))
                ivClock.setColorFilter(ContextCompat.getColor(context, R.color.white))
            } else {
                conPicture.visibility = View.GONE
                linearHour.background =
                    ContextCompat.getDrawable(context, R.drawable.round_12_gray)
                tvHour.setTextColor(ContextCompat.getColor(context, R.color.black))
            }

            setOnClickListener {
                selected = holder.absoluteAdapterPosition
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
