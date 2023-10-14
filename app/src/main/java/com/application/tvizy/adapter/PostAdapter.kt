package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Post
import com.application.tvizy.ui.activity.ProgramActivity
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(private val post: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivProgram.setImageDrawable(ContextCompat.getDrawable(context, post[position].image))
            tvHeading.text = post[position].text

            tvHeading.setOnClickListener {
                val intent = Intent(context, ProgramActivity::class.java)
                context.startActivity(intent)
            }

            linearSend.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = android.content.Intent.ACTION_SEND
                    putExtra(android.content.Intent.EXTRA_TEXT, "Paylaş")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                context.startActivity(shareIntent)
            }

        }
    }

    override fun getItemCount(): Int {
        return post.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
