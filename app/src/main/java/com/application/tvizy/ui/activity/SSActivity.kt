package com.application.tvizy.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.application.tvizy.R
import com.application.tvizy.service.Tools
import com.application.tvizy.ui.fragment.SSFragment

@Deprecated("removed")
class SSActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ssactivity)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameSS, SSFragment())
        transaction.addToBackStack(null)
        transaction.commit()

    }
}