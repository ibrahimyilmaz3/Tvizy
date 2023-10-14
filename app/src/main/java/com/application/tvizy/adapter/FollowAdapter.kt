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
import com.application.tvizy.ui.activity.FollowingActivity
import kotlinx.android.synthetic.main.item_my.view.*
import kotlinx.android.synthetic.main.item_program.view.ivChannel

class FollowAdapter : RecyclerView.Adapter<FollowAdapter.ViewHolder>() {

    private var profile = arrayListOf(
        Triple(R.drawable.example_profile_11, "Ayşe", "@ayse"),
        Triple(R.drawable.show_tv, "Show TV", "@showtv"),
        Triple(R.drawable.example_profile_2, "Selin", "@selin"),
        Triple(R.drawable.star_tv, "Star TV", "@startv"),
        Triple(R.drawable.example_profile_3, "Beril", "@beril"),
        Triple(R.drawable.atv, "ATV", "@atv"),
        Triple(R.drawable.example_profile_4, "Berk", "@berk"),
        Triple(R.drawable.kanal_d, "Kanal D", "@kanald"),
        Triple(R.drawable.example_profile_5, "Mert", "@mert"),
        Triple(R.drawable.show_tv, "Show TV", "@showtv"),
        Triple(R.drawable.example_profile_6, "Mehmet", "@mehmet"),
        Triple(R.drawable.example_profile_7, "Can", "@can"),
        Triple(R.drawable.star_tv, "Star TV", "@startv"),
        Triple(R.drawable.example_profile_8, "Alican", "@alican"),
        Triple(R.drawable.atv, "ATV", "@atv"),
        Triple(R.drawable.example_profile_9, "Hamed", "@hamed"),
        Triple(R.drawable.kanal_d, "Kanal D", "@kanald"),
        Triple(R.drawable.example_profile_10, "Taylan", "@taylan")
    )

    private lateinit var context: Context
    private val list = arrayListOf<Int>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_my, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: FollowAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivChannel.setImageDrawable(ContextCompat.getDrawable(context, profile[position].first))
            tvName.text = profile[position].second
            tvUsername.text = profile[position].third
            setOnClickListener {
                when (position) {
                    1, 3, 5, 7, 9, 11, 12, 14, 16 -> {
                        val intent =
                            Intent((context as AppCompatActivity), ChannelActivity::class.java)
                        context.startActivity(intent)
                    }
                    else -> {
                        val intent =
                            Intent((context as AppCompatActivity), FollowingActivity::class.java)
                        context.startActivity(intent)
                    }
                }
            }

            if (list.contains(holder.absoluteAdapterPosition)) {
                ivCheck.visibility = View.GONE
                tvFollow.visibility = View.VISIBLE
            } else {
                ivCheck.visibility = View.VISIBLE
                tvFollow.visibility = View.GONE
            }

            ivCheck.setOnClickListener {
                list.add(holder.absoluteAdapterPosition)
                ivCheck.visibility = View.GONE
                tvFollow.visibility = View.VISIBLE
                notifyDataSetChanged()
            }
            tvFollow.setOnClickListener {
                list.remove(holder.absoluteAdapterPosition)
                ivCheck.visibility = View.VISIBLE
                tvFollow.visibility = View.GONE
                notifyDataSetChanged()
            }

        }
    }

    override fun getItemCount(): Int {
        return profile.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
