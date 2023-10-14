package com.application.tvizy.ui.activity

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.adapter.ProgramAdapter
import com.application.tvizy.adapter.StoryAdapter
import com.application.tvizy.model.Home
import com.application.tvizy.service.Tools
import com.application.tvizy.util.funIntent
import com.application.tvizy.util.navigation
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var layoutManagerVertical: RecyclerView.LayoutManager? = null
    private val send = ArrayList<Home>()
    private val list = arrayListOf<SpannableString>()
    private val listImg = arrayListOf<Int>()
    private val listChannel = arrayListOf<Int>()
    private val listName = arrayListOf<String>()

    private var backPressedOnce = false
    private var doubleBackPressedTime: Long = 0

    override fun onBackPressed() {
        if (backPressedOnce) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - doubleBackPressedTime < 2000) {
                super.onBackPressed()
            } else {
                backPressedOnce = false
            }
        } else {
            backPressedOnce = true
            doubleBackPressedTime = System.currentTimeMillis()
            Toast.makeText(this, "Çıkış yapmak için tekrar dokunun", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        navigation("home")

        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        layoutManagerVertical = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        rvStory.layoutManager = layoutManager
        val adapter = StoryAdapter()
        rvStory.adapter = adapter

        rvPost.layoutManager = layoutManagerVertical
        val adapterProgram = ProgramAdapter(send)
        rvPost.adapter = adapterProgram

        name()
        channel()
        image()
        span()
        dataInitialize()


        linearNot.setOnClickListener {
            funIntent(NotificationActivity())
        }

        linearMessage.setOnClickListener {
            funIntent(MessageActivity())
        }

        /*conBanner.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.maisonmargiela.com/wx/"))
            startActivity(i)
        }*/
    }


    private fun dataInitialize() {
        for (i in 0..4) {
            send.add(
                Home(
                    list[i], listImg[i], listChannel[i], listName[i]
                )
            )
        }
    }

    private fun span(): ArrayList<SpannableString> {
        val s0 = "Gentle Monster kataloğu yayında! #maisonmargiela"
        val ad = SpannableString(s0)
        ad.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            33, 48, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(ad)
        val s1 = "Müge Anlı gün ortasında sizinle birlikte! #mügeanli"
        val span = SpannableString(s1)
        span.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            42, 51, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span)
        val s2 = "Yeni bölüm Cuma Saat 20:00’da! #yalıçapkını"
        val span2 = SpannableString(s2)
        span2.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            31, 43, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span2)
        val s3 = "Ebru&Murat Bu Sabah ile güne başla! #ebruvemurat"
        val span3 = SpannableString(s3)
        span3.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            36, 48, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span3)
        val s4 = "Neler Oluyor Hayatta ekranlarda! #neleroluyorhayatta"
        val span4 = SpannableString(s4)
        span4.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            33, 52, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span4)
        val s5 =
            "Esra Ezmeci ile Karşı Karşıya'da bu hafta Hülya Avşar Yeşilçam'ı anlatıyor! #esraezmeci"
        val span5 = SpannableString(s5)
        span5.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.light_purple)),
            76, 87, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span5)

        return list
    }
    private fun image(): ArrayList<Int> {
        listImg.add(R.drawable.banner_2)
        listImg.add(R.drawable.example_program)
        listImg.add(R.drawable.example_program_2)
        listImg.add(R.drawable.example_program_3)
        listImg.add(R.drawable.example_program_4)
        listImg.add(R.drawable.example_program_5)
        return listImg
    }
    private fun channel(): ArrayList<Int> {
        listChannel.add(R.drawable.tvizy_icon)
        listChannel.add(R.drawable.atv)
        listChannel.add(R.drawable.star_tv)
        listChannel.add(R.drawable.atv)
        listChannel.add(R.drawable.kanal_d)
        listChannel.add(R.drawable.show_tv)
        return listChannel
    }
    private fun name(): ArrayList<String> {
        listName.add("Tvizy")
        listName.add("ATV")
        listName.add("Star TV")
        listName.add("ATV")
        listName.add("Kanal D")
        listName.add("Show TV")
        return listName
    }

}