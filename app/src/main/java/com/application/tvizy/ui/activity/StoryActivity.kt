package com.application.tvizy.ui.activity

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.adapter.PagerStory
import com.application.tvizy.anim.CubeTransformer
import com.application.tvizy.model.*
import com.application.tvizy.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_story.*

class StoryActivity : BaseAppCompatActivity() {

//    private var layoutManager: RecyclerView.LayoutManager? = null

    private var story = ArrayList<Story>()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        transparentStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        dataInitialize()
        viewPager()
        channelScroll()

        var position = intent.getIntExtra("channel", 0)
        viewPager.setCurrentItem(position, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun channelScroll() {

        /*
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvFull)
        rvFull.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            val pos =
                rvFull.layoutManager!!.getPosition(snapHelper.findSnapView(rvFull.layoutManager)!!)

            if (pos == 0) {
                ivChannel.setImageDrawable(ContextCompat.getDrawable(this, story[0].first))
                tvName.text = story[0].second
            } else if (pos == 1) {
                ivChannel.setImageDrawable(ContextCompat.getDrawable(this, story[1].first))
                tvName.text = story[1].second
            } else if (pos == 2) {
                ivChannel.setImageDrawable(ContextCompat.getDrawable(this, story[2].first))
                tvName.text = story[2].second
            } else if (pos == 3) {
                ivChannel.setImageDrawable(ContextCompat.getDrawable(this, story[3].first))
                tvName.text = story[3].second
            } else if (pos == 4) {
                ivChannel.setImageDrawable(ContextCompat.getDrawable(this, story[4].first))
                tvName.text = story[4].second
            }
        }



        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == 0) {
                    ivChannel.setImageDrawable(
                        ContextCompat.getDrawable(
                            viewPager.context,
                            story[0].first
                        )
                    )
                    tvName.text = story[0].second
                } else if (position == 1) {
                    ivChannel.setImageDrawable(
                        ContextCompat.getDrawable(
                            viewPager.context,
                            story[1].first
                        )
                    )
                    tvName.text = story[1].second
                } else if (position == 2) {
                    ivChannel.setImageDrawable(
                        ContextCompat.getDrawable(
                            viewPager.context,
                            story[2].first
                        )
                    )
                    tvName.text = story[2].second
                } else if (position == 3) {
                    ivChannel.setImageDrawable(
                        ContextCompat.getDrawable(
                            viewPager.context,
                            story[3].first
                        )
                    )
                    tvName.text = story[3].second
                } else if (position == 4) {
                    ivChannel.setImageDrawable(
                        ContextCompat.getDrawable(
                            viewPager.context,
                            story[4].first
                        )
                    )
                    tvName.text = story[4].second
                }

            }
        })
         */
    }


    private fun viewPager() {
/*
        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
*/
        viewPager.adapter = PagerStory(this, story)
        viewPager.setPageTransformer(CubeTransformer())
        (viewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }


    private fun transparentStatusBar(context: Context, window: Window) {
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

    private fun dataInitialize() {

        story.add(
            Story(
                null,
                null,
                null,
                null,
                Ads(R.drawable.tvizy_icon, "Tvizy", R.drawable.ad_story),
                "ads"
            )
        )

        story.add(
            Story(
                null,
                null,
                null,
                Comment2(
                    R.drawable.show_tv,
                    "Show TV",
                    R.drawable.example_series_3,
                    "Elif - Yorum gönder",
                    R.drawable.series_3,
                    R.drawable.banner_2, "Fatma Mehmet'e kızgın!"
                ),
                null,
                viewType = "comment"
            )
        )

        story.add(
            Story(
                null,
                null,
                Question2(
                    R.drawable.star_tv,
                    "Star TV",
                    R.drawable.example_series_2,
                    "Güzel Günler - Soru gönder",
                    R.drawable.series_good_days,
                    R.drawable.banner_2, "Fatih'in en sevdiği renk sence nedir?"
                ),
                null,
                null,
                viewType = "question"
            )
        )

        val (spanA11, spanB11) = compOption()
        story.add(
            Story(
                null, Competition2(
                    R.drawable.atv,
                    "ATV",
                    R.drawable.example_series,
                    "Adım Farah - Günün yarışması",
                    R.drawable.series_2,
                    R.drawable.banner_2,
                    "Fatih'in en sevdiği renk hangisi?",
                    spanA11,
                    spanB11, "Mehmet'in en sevdiği renk hangisi?",
                    spanA11,
                    spanB11, "Hasan'ın en sevdiği renk hangisi?",
                    spanA11,
                    spanB11,
                ), null, null, null, viewType = "competition"
            )
        )


        val (spanA1, spanB1) = optionSender()

        story.add(
            Story(
                Survey2(
                    R.drawable.kanal_d,
                    "Kanal D",
                    R.drawable.example_series_4,
                    "Bir Peri Masalı",
                    R.drawable.series_tale,
                    R.drawable.banner_2,
                    "Sence Fatih haklı mı?",
                    spanA1,
                    spanB1
                ), null, null, null, null, viewType = "survey"
            )
        )

    }

    private fun optionSender(): Pair<SpannableString, SpannableString> {
        val a1 = "a) Evet"
        val b1 = "b) Hayır"

        val spanA1 = SpannableString(a1)
        spanA1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spanA1.setSpan(
            AbsoluteSizeSpan(35),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val spanB1 = SpannableString(b1)
        spanB1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        spanB1.setSpan(
            AbsoluteSizeSpan(35),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        return Pair(spanA1, spanB1)
    }

    private fun compOption(): Pair<SpannableString, SpannableString> {
        val a1 = "a) Sarı"
        val b1 = "b) Mavi"

        val spanA1 = SpannableString(a1)
        spanA1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spanA1.setSpan(
            AbsoluteSizeSpan(35),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val spanB1 = SpannableString(b1)
        spanB1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        spanB1.setSpan(
            AbsoluteSizeSpan(35),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        return Pair(spanA1, spanB1)
    }

}