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
import com.application.tvizy.ui.activity.ChannelActivity
import eightbitlab.com.blurview.BlurViewFacade
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.item_reel.view.*

class ReelsAdapter() :
    RecyclerView.Adapter<ReelsAdapter.ViewHolder>() {

    private var program = arrayOf(
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel,
        R.drawable.example_reel_2,
        R.drawable.example_reel_3,
        R.drawable.example_reel
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReelsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_reels, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ReelsAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivReel.setImageDrawable(ContextCompat.getDrawable(context, program[position]))
        }
    }

    override fun getItemCount(): Int {
        return program.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}