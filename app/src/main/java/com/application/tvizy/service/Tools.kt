package com.application.tvizy.service

import android.content.Context
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.application.tvizy.R
import java.text.SimpleDateFormat
import java.util.*

class Tools {

    fun transparentStatusBar(context: Context, window: Window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, R.color.none)
        window.decorView.systemUiVisibility = 0
    }

    fun whiteStatusBar(context: Context, window: Window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    fun appColorStatusBar(context: Context, window: Window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, R.color.light_purple)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    fun todayDate(): String{
        val df = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date= df.format(Calendar.getInstance().time)
        return date
    }

    /*fun openBrowser(activity: Activity, url:String){
        val uri = Uri.parse(url)
        val intentBuilder = CustomTabsIntent.Builder()
        intentBuilder.setToolbarColor(ContextCompat.getColor(activity, R.color.green))
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(activity, R.color.white))
        val customTabsIntent = intentBuilder.build()
        customTabsIntent.launchUrl(activity, uri)
    }*/

    companion object{
        fun whiteStatusBar(context: Context, window: Window) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(context, R.color.white)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }
}


object AppCompactUtil{
    fun whiteStatusBar(context: Context, window: Window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}
fun AppCompatActivity.whiteStatusBar() {
    window.apply {
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        statusBarColor = ContextCompat.getColor(context, R.color.white)
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}