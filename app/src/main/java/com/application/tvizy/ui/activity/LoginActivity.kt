package com.application.tvizy.ui.activity

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.application.tvizy.R
import com.application.tvizy.util.BaseAppCompatActivity
import com.application.tvizy.util.funClearIntent
import com.application.tvizy.util.funIntent
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseAppCompatActivity() {

    private var selected1 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        transparentStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        etNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher())

        linearSignUp.setOnClickListener {
            funIntent(SignUpActivity())
        }

        btnLogin.setOnClickListener {
           // if (etPassword.text.length < 8) {
           //     etPassword.error = "Şifreniz minimum 8 karakter olmalıdır!"
           // } else {
                funClearIntent(SuggestActivity())
           // }
        }

        ivToggle1.setOnClickListener {
            if (selected1 == 0) {
                etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected1 = 1
                ivToggle1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_hide))
            } else {
                etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                selected1 = 0
                ivToggle1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.eye_show))
            }
        }

        mainCon.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
        mainNested.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
        mainLinear.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

    }

    fun transparentStatusBar(context: Context, window: Window) {
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

}