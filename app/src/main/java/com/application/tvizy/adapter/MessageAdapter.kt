package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Message
import com.application.tvizy.ui.activity.SendActivity
import com.application.tvizy.util.MainObject
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter(var message: ArrayList<Message>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessageAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MessageAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            tvName.text = message[position].name
            ivProfile.setImageDrawable(ContextCompat.getDrawable(context, message[position].image))
            setOnClickListener {
                Log.d("ddd", message[holder.adapterPosition].name)
                MainObject.person = position
                val intent = Intent(context, SendActivity::class.java)
                intent.putExtra("name", message[holder.adapterPosition].name)
                intent.putExtra("image", message[holder.adapterPosition].image)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return message.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
