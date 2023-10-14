package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Now
import com.application.tvizy.ui.activity.ProgramActivity
import kotlinx.android.synthetic.main.item_now.view.*

class NowAdapter(private val imagesArrayList: ArrayList<Now>) :
    RecyclerView.Adapter<NowAdapter.ViewHolder>() {

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
        R.drawable.show_tv
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NowAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_now, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: NowAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivChannel.setImageDrawable(ContextCompat.getDrawable(context, program[position]))

            setOnClickListener {
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
