package com.application.tvizy.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.application.tvizy.util.funClearIntent
import com.application.tvizy.util.funIntent
import com.application.tvizy.R
import com.application.tvizy.service.Tools
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        linearBack.setOnClickListener {
            finish()
        }

        linearSeries.setOnClickListener {
            funIntent(FollowActivity())
        }

        linearAccount.setOnClickListener {
            funIntent(AccountActivity())
        }

        linearLogout.setOnClickListener {
            funClearIntent(LoginActivity())
        }

        linearChange.setOnClickListener {
            funIntent(ChangeActivity())
        }
    }
}