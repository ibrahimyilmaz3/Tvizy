package com.application.tvizy.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.application.tvizy.util.BaseAppCompatActivity
import com.application.tvizy.util.funIntent
import com.application.tvizy.R
import com.application.tvizy.adapter.PagerProgram
import com.application.tvizy.service.Tools
import com.application.tvizy.ui.fragment.AboutFragment
import com.application.tvizy.ui.fragment.ProductFragment
import com.application.tvizy.ui.fragment.SponsorFragment
import kotlinx.android.synthetic.main.activity_program.*

class ProgramActivity : BaseAppCompatActivity() {

    private var selected = 0

    private val fragmentList = arrayListOf(
        SponsorFragment(),
        ProductFragment(),
        AboutFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_program)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        clear()
        tvSponsor.setTextColor(ContextCompat.getColor(this, R.color.light_purple))
        view1.visibility = View.INVISIBLE

        linearSponsor.setOnClickListener {
            sponsor()
        }
        linearProduct.setOnClickListener {
            product()
        }
        linearAbout.setOnClickListener {
            about()
        }

        //ViewPager
        val pagerAdapter = PagerProgram(fragmentList, supportFragmentManager, lifecycle)
        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> sponsor()
                    1 -> product()
                    2 -> about()
                }
            }
        })
        (viewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        linearAdd.setOnClickListener {

            if (selected == 0) {
                tvAdd.text = "Kaydedildi"
                ivAdd.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.tick_black))
                selected = 1
            } else {
                tvAdd.text = "Kaydet"
                ivAdd.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.add))
                selected = 0
            }
        }

        linearBack.setOnClickListener {
            finish()
        }

        linearChannel.setOnClickListener {
            funIntent(ChannelActivity())
        }

    }


    private fun sponsor() {
        clear()
        viewPager.setCurrentItem(0, true)
        tvSponsor.setTextColor(ContextCompat.getColor(this, R.color.black))
        view1.visibility = View.VISIBLE
    }

    private fun product() {
        clear()
        viewPager.setCurrentItem(1, true)
        tvProduct.setTextColor(ContextCompat.getColor(this, R.color.black))
        view2.visibility = View.VISIBLE
    }

    private fun about() {
        clear()
        viewPager.setCurrentItem(4, true)
        tvAbout.setTextColor(ContextCompat.getColor(this, R.color.black))
        view3.visibility = View.VISIBLE
    }

    private fun clear() {
        tvSponsor.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        tvProduct.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        tvAbout.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        view1.visibility = View.INVISIBLE
        view2.visibility = View.INVISIBLE
        view3.visibility = View.INVISIBLE
    }

}