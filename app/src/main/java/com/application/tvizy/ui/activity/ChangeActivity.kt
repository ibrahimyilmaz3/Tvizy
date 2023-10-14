package com.application.tvizy.ui.activity

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.application.tvizy.R
import com.application.tvizy.service.Tools
import com.application.tvizy.ui.dialog.PasswordFragment
import com.application.tvizy.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_change.*

class ChangeActivity : BaseAppCompatActivity() {

    private var selected1 = 0
    private var selected2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        linearBack.setOnClickListener {
            finish()
        }

        btnSave.setOnClickListener {
            if (etOld.text.length < 8) {
                etOld.error = "Şifreniz minimum 8 karakter olmalıdır!"
            } else if (etNew.text.length < 8) {
                etNew.error = "Şifreniz minimum 8 karakter olmalıdır!"
            } else if (etAgain.text.toString() != etNew.text.toString()) {
                etAgain.error = "Girdiğiniz şifreler uyuşmuyor!"
                etNew.error = "Girdiğiniz şifreler uyuşmuyor!"
            } else if (etAgain.text.toString() == etOld.text.toString()) {
                etAgain.error = "Girdiğiniz şifre eski şifrenizle aynı!"
                etNew.error = "Girdiğiniz şifre eski şifrenizle aynı!"
            } else {
                val passwordFragment = PasswordFragment()
                passwordFragment.show(supportFragmentManager, "passwordFragment")
            }
        }

        ivToggle1.setOnClickListener {
            if (selected1 == 0) {
                etOld.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected1 = 1
                ivToggle1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etOld.transformationMethod = PasswordTransformationMethod.getInstance()
                selected1 = 0
                ivToggle1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
            }
        }
        ivToggle2.setOnClickListener {
            if (selected2 == 0) {
                etNew.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected2 = 1
                ivToggle2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etNew.transformationMethod = PasswordTransformationMethod.getInstance()
                selected2 = 0
                ivToggle2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
            }
        }
        ivToggle3.setOnClickListener {
            if (selected2 == 0) {
                etAgain.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected2 = 1
                ivToggle3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etAgain.transformationMethod = PasswordTransformationMethod.getInstance()
                selected2 = 0
                ivToggle3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
            }
        }

    }
}