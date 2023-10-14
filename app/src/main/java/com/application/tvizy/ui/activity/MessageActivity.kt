package com.application.tvizy.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.adapter.MessageAdapter
import com.application.tvizy.model.Message
import com.application.tvizy.service.Tools
import com.application.tvizy.util.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : BaseAppCompatActivity() {

    private var list = arrayListOf<Message>()
    private var list2 = arrayListOf<Message>()

    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        dataInitialize()

        layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvMessage.layoutManager = layoutManager
        val adapter = MessageAdapter(list)
        rvMessage.adapter = adapter

        linearBack.setOnClickListener {
            finish()
        }

        linearNew.setOnClickListener {
            val intent = Intent(this, SendActivity::class.java)
            intent.putExtra("image", R.drawable.tvizy_icon)
            intent.putExtra("name", "Tvizy")
            startActivity(intent)
        }

        etSearch.addTextChangedListener {
            when (etSearch.text.toString().length) {
                0 -> {
                    val adapterSearch = MessageAdapter(list)
                    rvMessage.adapter = adapterSearch
                }
                else -> {
                    list2.clear()
                    for (i in list) {
                        if (i.name.contains("${etSearch.text}", true)) {
                            list2.add(i)
                        }
                    }
                    val adapterSearch = MessageAdapter(list2)
                    rvMessage.adapter = adapterSearch
                }
            }
        }

    }

    private fun dataInitialize() {
        list.add(Message(R.drawable.example_profile_11, "Ayşe"))
        list.add(Message(R.drawable.show_tv, "Show TV"))
        list.add(Message(R.drawable.example_profile_2, "Selin"))
        list.add(Message(R.drawable.star_tv, "Star TV"))
        list.add(Message(R.drawable.example_profile_3, "Beril"))
        list.add(Message(R.drawable.atv, "ATV"))
        list.add(Message(R.drawable.example_profile_4, "Berk"))
        list.add(Message(R.drawable.kanal_d, "Kanal D"))
        list.add(Message(R.drawable.example_profile_5, "Mert"))
        list.add(Message(R.drawable.example_profile_6, "Mehmet"))
        list.add(Message(R.drawable.example_profile_7, "Can"))
        list.add(Message(R.drawable.example_profile_8, "Alican"))
        list.add(Message(R.drawable.example_profile_9, "Hamed"))
        list.add(Message(R.drawable.example_profile_10, "Taylan"))
    }

}