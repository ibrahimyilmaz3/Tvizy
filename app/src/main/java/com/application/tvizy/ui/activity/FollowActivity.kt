package com.application.tvizy.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.adapter.FollowAdapter
import com.application.tvizy.service.Tools
import kotlinx.android.synthetic.main.activity_follow.*

class FollowActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_follow)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvMy.layoutManager = layoutManager
        val adapterProgram = FollowAdapter()
        rvMy.adapter = adapterProgram

        linearBack.setOnClickListener {
            finish()
        }
    }
}