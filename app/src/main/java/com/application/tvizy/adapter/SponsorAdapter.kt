package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import kotlinx.android.synthetic.main.item_sponsor.view.*

class SponsorAdapter : RecyclerView.Adapter<SponsorAdapter.ViewHolder>() {

    private var program = arrayOf(
        R.drawable.banner,
        R.drawable.banner_2,
        R.drawable.banner_3,
        R.drawable.banner_4,
        R.drawable.banner,
        R.drawable.banner_2,
        R.drawable.banner_3,
        R.drawable.banner_4,
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SponsorAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_sponsor, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: SponsorAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            ivSponsor.setImageDrawable(ContextCompat.getDrawable(context, program[position]))
            setOnClickListener {
                when (position) {
                    0,4 -> {
                        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://getir.com/"))
                        context.startActivity(i)
                    }
                    1,5 ->{
                        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.maisonmargiela.com/wx/"))
                        context.startActivity(i)
                    }
                    2,6 -> {
                        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.volvocars.com/tr/"))
                        context.startActivity(i)
                    }
                    3,7 -> {
                        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bosch.com.tr/"))
                        context.startActivity(i)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return program.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
