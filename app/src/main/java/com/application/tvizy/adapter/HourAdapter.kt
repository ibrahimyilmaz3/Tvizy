package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Hour
import com.application.tvizy.ui.activity.ChannelActivity
import com.application.tvizy.ui.activity.ProgramActivity
import kotlinx.android.synthetic.main.item_hour.view.*
import kotlinx.android.synthetic.main.item_now.view.ivChannel
import kotlinx.android.synthetic.main.item_now.view.linearChannel

class HourAdapter(private val imagesArrayList: ArrayList<Hour>) :
    RecyclerView.Adapter<HourAdapter.ViewHolder>() {

    private var program = arrayOf(
        R.drawable.show_tv,
        R.drawable.star_tv,
        R.drawable.atv,
        R.drawable.kanal_d,
        R.drawable.show_tv,
        R.drawable.star_tv,
        R.drawable.atv,
        R.drawable.kanal_d,
        R.drawable.show_tv,
        R.drawable.star_tv,
        R.drawable.atv,
        R.drawable.kanal_d,
        R.drawable.show_tv,
        R.drawable.star_tv,
        R.drawable.atv,
        R.drawable.kanal_d,
        R.drawable.show_tv,
        R.drawable.star_tv,
        R.drawable.atv,
        R.drawable.kanal_d,
        R.drawable.show_tv,
        R.drawable.star_tv,
        R.drawable.atv,
        R.drawable.kanal_d,
        R.drawable.show_tv
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HourAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_hour, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: HourAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivChannel.setImageDrawable(ContextCompat.getDrawable(context, program[position]))

            linearChannel.setOnClickListener {
                val intent = Intent(context, ChannelActivity::class.java)
                context.startActivity(intent)
            }
            linearProgram.setOnClickListener {
                val intent = Intent(context, ProgramActivity::class.java)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return program.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}