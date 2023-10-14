package com.application.tvizy.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.application.tvizy.R
import com.application.tvizy.ui.activity.*
import kotlinx.android.synthetic.main.navigation.*

open class BaseAppCompatActivity : AppCompatActivity() {

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        return true
    }
}

fun AppCompatActivity.funIntent(activity: Activity) {
    val intent = Intent(applicationContext, activity::class.java)
    startActivity(intent)
}
fun AppCompatActivity.funClearIntent(activity: Activity) {
    val intent = Intent(applicationContext, activity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
}
fun AppCompatActivity.funClearAnimationIntent(activity: Activity) {
    val intent = Intent(applicationContext, activity::class.java)
    startActivity(intent)
    overridePendingTransition(R.anim.fade_in, R.anim.none)
    finish()
}

fun AppCompatActivity.navigation(current: String){
    when(current){
        "home" -> {
            ivHome.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.home_clicked))
            ivHome.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
            tvHome.setTextColor(ContextCompat.getColor(this, R.color.light_purple))
        }
        "explorer" -> {
            ivExplore.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.search_clicked))
            ivExplore.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
            tvExplore.setTextColor(ContextCompat.getColor(this, R.color.light_purple))
        }
        "reel" -> {
            ivReel.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.play_clicked))
            ivReel.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
            tvReel.setTextColor(ContextCompat.getColor(this, R.color.light_purple))
        }
        "cat" -> {
            ivCat.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.category_clicked))
            ivCat.setColorFilter(ContextCompat.getColor(this, R.color.light_purple))
            tvCat.setTextColor(ContextCompat.getColor(this, R.color.light_purple))
        }
        "profile" -> {
            tvProfile.setTextColor(ContextCompat.getColor(this, R.color.light_purple))
        }
    }
    linearHome.setOnClickListener {
        if(current != "home") funClearAnimationIntent(HomeActivity())
    }
    linearExplore.setOnClickListener {
        if(current != "explorer") funClearAnimationIntent(ExploreActivity())
    }
    linearReel.setOnClickListener {
        if(current != "reel") funClearAnimationIntent(ReelActivity())
    }
    linearCat.setOnClickListener {
        if(current != "cat") funClearAnimationIntent(CategoryActivity())
    }
    linearProfile.setOnClickListener {
        if(current != "profile") funClearAnimationIntent(ProfileActivity())
    }
}

fun AppCompatActivity.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()