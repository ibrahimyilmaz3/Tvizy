package com.application.tvizy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import kotlinx.android.synthetic.main.item_onboard.view.*

class OnboardAdapter : RecyclerView.Adapter<OnboardAdapter.ViewHolder>() {

    private var titles = arrayOf(
        "Canlı anketler, yarışmalar, dizi ve programlar hakkında her şey tek bir uygulamada!",
        "Tüm TV kanalları, sevdiğiniz dizi ve programlar ve daha fazlası!",
        "Bambaşka bir televizyon deneyimi sizi bekliyor!"
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnboardAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_onboard, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: OnboardAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            tvHeading.text = titles[position]
        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
