package com.application.tvizy.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.application.tvizy.R
import com.application.tvizy.adapter.PagerChannel
import com.application.tvizy.service.Tools
import com.application.tvizy.ui.fragment.*
import kotlinx.android.synthetic.main.activity_channel.*

class ChannelActivity : AppCompatActivity() {

    private var selected = 0

    private val fragmentList = arrayListOf(
        OnlineFragment(),
        PostFragment(),
        ReelFragment(),
        ProgramFragment(),
        StreamFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channel)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        clear()
        tvOnline.setTextColor(ContextCompat.getColor(this, R.color.light_purple))
        view1.visibility = View.INVISIBLE

        linearOnline.setOnClickListener {
            online()
        }
        linearPost.setOnClickListener {
            post()
        }
        linearReel.setOnClickListener {
            reel()
        }
        linearProgram.setOnClickListener {
            program()
        }
        linearStream.setOnClickListener {
            stream()
        }

        //ViewPager
        val pagerAdapter = PagerChannel(fragmentList, supportFragmentManager, lifecycle)
        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> online()
                    1 -> post()
                    2 -> reel()
                    3 -> program()
                    4 -> stream()
                }
            }
        })
        (viewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        linearFollow.setOnClickListener {

            if (selected == 0) {
                tvFollow.text = "Takip Et"
                ivFollow.visibility = View.GONE
                selected = 1
            } else {
                tvFollow.text = "Takip"
                ivFollow.visibility = View.VISIBLE
                selected = 0
            }
        }

        linearBack.setOnClickListener {
            finish()
        }

        tvLive.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.showtv.com.tr/canli-yayin"))
            startActivity(i)
        }

        linearMessage.setOnClickListener {
            val intent = Intent(this, SendActivity::class.java)
            intent.putExtra("image", R.drawable.show_tv)
            intent.putExtra("name", "Show TV")
            startActivity(intent)
        }

    }

    private fun stream() {
        clear()
        viewPager.setCurrentItem(4, true)
        tvStream.setTextColor(ContextCompat.getColor(this, R.color.black))
        view5.visibility = View.VISIBLE
    }

    private fun program() {
        clear()
        viewPager.setCurrentItem(3, true)
        tvProgram.setTextColor(ContextCompat.getColor(this, R.color.black))
        view4.visibility = View.VISIBLE
    }

    private fun reel() {
        clear()
        viewPager.setCurrentItem(2, true)
        tvReel.setTextColor(ContextCompat.getColor(this, R.color.black))
        view3.visibility = View.VISIBLE
    }

    private fun post() {
        clear()
        viewPager.setCurrentItem(1, true)
        tvPost.setTextColor(ContextCompat.getColor(this, R.color.black))
        view2.visibility = View.VISIBLE
    }

    private fun online() {
        clear()
        viewPager.setCurrentItem(0, true)
        tvOnline.setTextColor(ContextCompat.getColor(this, R.color.black))
        view1.visibility = View.VISIBLE
    }

    private fun clear() {
        tvOnline.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        tvPost.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        tvReel.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        tvProgram.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        tvStream.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        view1.visibility = View.INVISIBLE
        view2.visibility = View.INVISIBLE
        view3.visibility = View.INVISIBLE
        view4.visibility = View.INVISIBLE
        view5.visibility = View.INVISIBLE
    }
}