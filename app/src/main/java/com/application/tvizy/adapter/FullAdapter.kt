package com.application.tvizy.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.ui.activity.ChannelActivity
import kotlinx.android.synthetic.main.item_ads.view.*

@Deprecated("Switched to ViewPager2: PagerStory.kt")
class FullAdapter : RecyclerView.Adapter<FullAdapter.ViewHolder>() {

    private val story = arrayListOf(
        Triple(R.drawable.tvizy_icon, "Tvizy", R.drawable.ad_story),
        Triple(R.drawable.show_tv, "Show TV", R.drawable.ss_1),
        Triple(R.drawable.star_tv, "Star TV", R.drawable.ss_2),
        Triple(R.drawable.atv, "ATV", R.drawable.ss_3),
        Triple(R.drawable.kanal_d, "Kanal D", R.drawable.ss_1)
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FullAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_ads, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: FullAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {

            if (position == 0) {
                ivStory.foreground = null
                linearHide.visibility = View.GONE
                ivProduct.visibility = View.GONE
            } else {
                ivStory.foreground = ContextCompat.getDrawable(context, R.color.black_30)
                linearHide.visibility = View.VISIBLE
                ivProduct.visibility = View.VISIBLE
            }

            /*etAnswer.setOnFocusChangeListener { view, b ->
                run {
                    etAnswer.setText("", TextView.BufferType.EDITABLE)
                }
            }*/

            ivStory.setImageDrawable(ContextCompat.getDrawable(context, story[position].third))
            ivChannel.setImageDrawable(ContextCompat.getDrawable(context, story[position].first))

            setOnClickListener {
                val inputMethodManager =
                    (context as AppCompatActivity).getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                val view = (context as AppCompatActivity).currentFocus
                    ?: View(context as AppCompatActivity)
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                if (position == 0) {
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nike.com/tr/"))
                    context.startActivity(i)
                }
            }

            ivProduct.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nike.com/tr/"))
                context.startActivity(i)
            }

            cardChannel.setOnClickListener {
                val intent = Intent(context, ChannelActivity()::class.java)
                context.startActivity(intent)
            }


        }
    }


    override fun getItemCount(): Int {
        return story.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}