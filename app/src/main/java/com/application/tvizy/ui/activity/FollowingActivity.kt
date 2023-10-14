package com.application.tvizy.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.application.tvizy.R
import com.application.tvizy.adapter.PagerFollowing
import com.application.tvizy.service.Tools
import com.application.tvizy.ui.fragment.ChannelFragment
import com.application.tvizy.ui.fragment.FavoritesFragment
import com.application.tvizy.ui.fragment.GridFragment
import com.application.tvizy.util.funIntent
import kotlinx.android.synthetic.main.activity_following.*

class FollowingActivity : AppCompatActivity() {

    private var selected = 0
    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_following)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        fragmentList.add(FavoritesFragment())
        fragmentList.add(ChannelFragment())
        fragmentList.add(GridFragment())

        clear()
        tvFav.setTextColor(ContextCompat.getColor(this, R.color.black))
        view1.visibility = View.VISIBLE

        linearFav.setOnClickListener {
            clear()
            favorite()
            viewPager.setCurrentItem(0, true)
        }

        linearChannel.setOnClickListener {
            clear()
            channel()
            viewPager.setCurrentItem(1, true)
        }

        linearSave.setOnClickListener {
            clear()
            grid()
            viewPager.setCurrentItem(2, true)
        }

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

        val pagerAdapter = PagerFollowing(fragmentList, supportFragmentManager, lifecycle)
        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> favorite()
                    1 -> channel()
                    2 -> grid()
                }
            }
        })
        (viewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        linearMessage.setOnClickListener {
            funIntent(SendActivity())
        }
    }

    private fun favorite() {
        clear()
        view1.visibility = View.VISIBLE
        tvFav.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    private fun channel() {
        clear()
        view2.visibility = View.VISIBLE
        tvChannel.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    private fun grid() {
        clear()
        view3.visibility = View.VISIBLE
        tvSave.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    private fun transaction(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun clear() {

        view1.visibility = View.INVISIBLE
        view2.visibility = View.INVISIBLE
        view3.visibility = View.INVISIBLE
        tvFav.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        tvChannel.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
        tvSave.setTextColor(ContextCompat.getColor(this, R.color.color_BABABA))
    }

    override fun onBackPressed() {
        finish()
    }

}