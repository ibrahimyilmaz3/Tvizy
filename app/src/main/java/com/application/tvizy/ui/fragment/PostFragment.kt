package com.application.tvizy.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.PostAdapter
import com.application.tvizy.model.Post
import kotlinx.android.synthetic.main.fragment_post.*

class PostFragment : Fragment() {

    private lateinit var adapter: PostAdapter
    private lateinit var send: ArrayList<Post>
    private val list = arrayListOf<SpannableString>()
    private val listImg = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        span()
        image()
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)

        rvPost.layoutManager = layoutManager
        rvPost.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapter = PostAdapter(send)
        rvPost.adapter = adapter

        ivSponsor.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.maisonmargiela.com/wx/"))
            startActivity(i)
        }
    }

    private fun dataInitialize() {
        send = ArrayList<Post>()
        for (i in 0..4) {
            send.add(
                Post(
                    list[i], listImg[i]
                )
            )
        }
    }

    private fun span(): ArrayList<SpannableString> {
        val s1 = "Müge Anlı gün ortasında sizinle birlikte! #mügeanli"
        val span = SpannableString(s1)
        span.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_purple)),
            42, 51, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span)
        val s2 = "Yeni bölüm Cuma Saat 20:00’da! #yalıçapkını"
        val span2 = SpannableString(s2)
        span2.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_purple)),
            31, 43, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span2)
        val s3 = "Ebru&Murat Bu Sabah ile güne başla! #ebruvemurat"
        val span3 = SpannableString(s3)
        span3.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_purple)),
            36, 48, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span3)
        val s4 = "Neler Oluyor Hayatta ekranlarda! #neleroluyorhayatta"
        val span4 = SpannableString(s4)
        span4.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_purple)),
            33, 52, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span4)
        val s5 =
            "Esra Ezmeci ile Karşı Karşıya'da bu hafta Hülya Avşar Yeşilçam'ı anlatıyor! #esraezmeci"
        val span5 = SpannableString(s5)
        span5.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_purple)),
            76, 87, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        list.add(span5)

        return list
    }

    private fun image(): ArrayList<Int> {
        listImg.add(R.drawable.example_program)
        listImg.add(R.drawable.example_program_2)
        listImg.add(R.drawable.example_program_3)
        listImg.add(R.drawable.example_program_4)
        listImg.add(R.drawable.example_program_5)
        return listImg
    }

}