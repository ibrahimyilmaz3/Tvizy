package com.application.tvizy.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.ChooseAdapter
import com.application.tvizy.model.Category
import com.application.tvizy.service.Tools
import com.application.tvizy.util.funClearIntent
import kotlinx.android.synthetic.main.activity_suggest.*

class SuggestActivity : AppCompatActivity() {

    private val list = arrayListOf<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        channelInitialize()

        btnContinue.setOnClickListener {
            funClearIntent(HomeActivity())
        }

        rvSuggest.layoutManager = GridLayoutManager(this, 3)
        rvSuggest.adapter = ChooseAdapter(list)

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