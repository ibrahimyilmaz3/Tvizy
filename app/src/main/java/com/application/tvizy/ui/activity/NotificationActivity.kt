package com.application.tvizy.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.adapter.NotificationAdapter
import com.application.tvizy.service.Tools
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        linearBack.setOnClickListener {
            finish()
        }

        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvNot.layoutManager = layoutManager
        val adapter = NotificationAdapter()
        rvNot.adapter = adapter

    }
}