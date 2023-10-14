package com.application.tvizy.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.application.tvizy.util.BaseAppCompatActivity
import com.application.tvizy.R
import com.application.tvizy.service.Tools
import com.application.tvizy.ui.dialog.ChangeFragment
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.activity_settings.linearBack

class AccountActivity : BaseAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        linearBack.setOnClickListener {
            finish()
        }

        btnSave.setOnClickListener {
            val changeFragment = ChangeFragment()
            changeFragment.show(supportFragmentManager, "changeFragment")
        }
    }
}