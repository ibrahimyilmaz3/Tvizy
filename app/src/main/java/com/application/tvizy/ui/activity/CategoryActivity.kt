package com.application.tvizy.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.adapter.Choose2Adapter
import com.application.tvizy.adapter.TabAdapter
import com.application.tvizy.model.Category
import com.application.tvizy.service.Tools
import com.application.tvizy.util.BaseAppCompatActivity
import com.application.tvizy.util.funClearAnimationIntent
import com.application.tvizy.util.funIntent
import com.application.tvizy.util.navigation
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : BaseAppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private val list = arrayListOf<Category>()
    private val list2 = arrayListOf<Category>()

    override fun onBackPressed() {
        funClearAnimationIntent(HomeActivity())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        navigation("cat")
        channelInitialize()

        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        rvTab.layoutManager = layoutManager
        val adapter = TabAdapter()
        rvTab.adapter = adapter

        rvChannel.layoutManager = GridLayoutManager(this, 3)
        rvChannel.adapter = Choose2Adapter(list)

        ivStream.setOnClickListener {
            funIntent(BroadcastActivity())
        }

        etSearch.addTextChangedListener {
            when (etSearch.text.toString().length) {
                0 -> {
                    val adapterChoose = Choose2Adapter(list)
                    rvChannel.adapter = adapterChoose
                }
                else -> {

                    list2.clear()
                    for (i in list) {
                        if (i.name.contains("${etSearch.text}", true)) {
                            list2.add(i)
                        }
                    }

                    val adapterChoose = Choose2Adapter(list2)
                    rvChannel.adapter = adapterChoose
                }
            }
        }
    }

    private fun channelInitialize() {

        list.add(Category(R.drawable.atv, "ATV"))
        list.add(Category(R.drawable.kanal_d, "Kanal D"))
        list.add(Category(R.drawable.show_tv, "Show TV"))
        list.add(Category(R.drawable.fox_tv, "Fox Tv"))
        list.add(Category(R.drawable.kanal_7, "Kanal 7"))
        list.add(Category(R.drawable.tv_8, "Tv8"))
        list.add(Category(R.drawable.star_tv, "Star TV"))
        list.add(Category(R.drawable.tv_360, "360 TV"))
        list.add(Category(R.drawable.trt_1, "TRT1"))
        list.add(Category(R.drawable.tivibu, "Tivibu"))
        list.add(Category(R.drawable.tv_plus, "Tv+"))
        list.add(Category(R.drawable.blu_tv, "BluTV"))
        list.add(Category(R.drawable.netflix, "Netflix"))

    }
}