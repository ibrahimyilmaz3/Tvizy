package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Home
import com.application.tvizy.ui.activity.ChannelActivity
import com.application.tvizy.ui.activity.ProgramActivity
import kotlinx.android.synthetic.main.item_program.view.*

class ProgramAdapter(private val program: ArrayList<Home>) :
    RecyclerView.Adapter<ProgramAdapter.ViewHolder>() {

    private val list = ArrayList<Int>()
    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProgramAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_program, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProgramAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivProgram.setImageDrawable(ContextCompat.getDrawable(context, program[position].image))
            ivChannel.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    program[position].channel
                )
            )
            tvName.text = program[position].name
            tvHeading.text = program[position].text

            if (position == 0) {
                linearAction.visibility = View.GONE
                setOnClickListener {
                    val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.maisonmargiela.com/wx/")
                    )
                    context.startActivity(i)
                }
            }

            if (position != 0) {
                linearChannel.setOnClickListener {
                    val intent = Intent(context, ChannelActivity::class.java)
                    context.startActivity(intent)
                }
                tvHeading.setOnClickListener {
                    val intent = Intent(context, ProgramActivity::class.java)
                    context.startActivity(intent)
                }
            }

            if (list.contains(holder.absoluteAdapterPosition)) ivHeart.setImageDrawable(
                ContextCompat.getDrawable(context, R.drawable.heart_purple)
            ) else ivHeart.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.heart))

            ivHeart.setOnClickListener {
                if (list.contains(holder.absoluteAdapterPosition)) list.remove(holder.absoluteAdapterPosition)
                else list.add(holder.absoluteAdapterPosition)
                notifyDataSetChanged()
            }
            ivSave.setOnClickListener {
                Toast.makeText(context, "Gönderi kaydedildi!", Toast.LENGTH_SHORT).show()
            }
            ivShare.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Paylaş")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                context.startActivity(shareIntent)
            }
        }
    }

    override fun getItemCount(): Int {
        return program.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
