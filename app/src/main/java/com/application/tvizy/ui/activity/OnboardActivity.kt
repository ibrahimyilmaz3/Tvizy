package com.application.tvizy.ui.activity

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.adapter.OnboardAdapter
import com.application.tvizy.util.funClearIntent
import kotlinx.android.synthetic.main.activity_onboard.*
import kotlin.concurrent.fixedRateTimer

class OnboardActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)
        transparentStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        fixedRateTimer("autoScroll", false, 0, 30){
            runOnUiThread {
                scrollView.scrollBy(0, 2)
            }
        }

        touchBlocker.setOnClickListener {  }

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvOnboard)

        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        rvOnboard.layoutManager = layoutManager
        val adapter = OnboardAdapter()
        rvOnboard.adapter = adapter

        rvOnboard.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            var pos =
                rvOnboard.layoutManager!!.getPosition(snapHelper.findSnapView(rvOnboard.layoutManager)!!)
            for (i in listOf(firstDot, secondDot, thirdDot)) i.imageTintList = null
            when (pos) {
                0 -> firstDot.imageTintList =
                    ContextCompat.getColorStateList(this, R.color.light_purple)
                1 -> secondDot.imageTintList =
                    ContextCompat.getColorStateList(this, R.color.light_purple)
                2 -> thirdDot.imageTintList =
                    ContextCompat.getColorStateList(this, R.color.light_purple)
            }

            btnJoin.setOnClickListener {
                when (pos) {
                    0 -> {
                        rvOnboard.smoothScrollToPosition(pos + 1)
                    }
                    1 -> {
                        rvOnboard.smoothScrollToPosition(pos + 1)
                    }
                    2 -> funClearIntent(LoginActivity())
                }
            }
        }


    }

    private fun clearFocus() {

        firstDot.setColorFilter(
            ContextCompat.getColor(this, R.color.dot_not_focused),
            android.graphics.PorterDuff.Mode.MULTIPLY
        )

        secondDot.setColorFilter(
            ContextCompat.getColor(this, R.color.dot_not_focused),
            android.graphics.PorterDuff.Mode.MULTIPLY
        )

        thirdDot.setColorFilter(
            ContextCompat.getColor(this, R.color.dot_not_focused),
            android.graphics.PorterDuff.Mode.MULTIPLY
        )

    }

    fun transparentStatusBar(context: Context, window: Window) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}