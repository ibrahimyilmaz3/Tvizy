package com.application.tvizy.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.adapter.StreamAdapter
import com.application.tvizy.service.Tools
import com.application.tvizy.ui.fragment.HourFragment
import com.application.tvizy.ui.fragment.NowFragment
import kotlinx.android.synthetic.main.activity_broadcast.*

class BroadcastActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        rvTab.layoutManager = layoutManager
        val adapter = StreamAdapter()
        rvTab.adapter = adapter

        linearBack.setOnClickListener {
            finish()
        }

        adapter.selection.observe(this) {

            when (it) {
                0 -> transaction(NowFragment())
                else -> transaction(HourFragment())
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }

    private fun transaction(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}