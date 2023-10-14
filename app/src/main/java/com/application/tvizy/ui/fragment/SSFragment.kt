package com.application.tvizy.ui.fragment

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.TypefaceSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.application.tvizy.R
import com.application.tvizy.adapter.SSAdapter
import com.application.tvizy.model.Survey
import kotlinx.android.synthetic.main.fragment_online.*

@Deprecated("removed")
class SSFragment : Fragment() {

    private lateinit var adapter: SSAdapter
    private lateinit var send: ArrayList<Survey>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_s_s, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        optionSender()
        dataInitialize()

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvOnline)

        rvOnline.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = SSAdapter(send)
        rvOnline.adapter = adapter
    }

    private fun dataInitialize() {

        val (spanA1, spanB1) = optionSender()


        send = ArrayList<Survey>()
        send.add(
            Survey(
                R.drawable.example_series,
                "Güzel Günler",
                R.drawable.series_1,
                R.drawable.banner_2,
                "Sence Fatih haklı mı?",
                spanA1,
                spanB1
            )
        )
        send.add(
            Survey(
                R.drawable.example_series_2,
                "Adım Farah",
                R.drawable.series_2,
                R.drawable.banner_3,
                "Sence Mehmet haklı mı?",
                spanA1,
                spanB1
            )
        )
        send.add(
            Survey(
                R.drawable.example_series_3,
                "Elif",
                R.drawable.series_3,
                R.drawable.banner_4,
                "Sence Elif haklı mı?",
                spanA1,
                spanB1
            )
        )
    }

    private fun optionSender(): Pair<SpannableString, SpannableString> {
        val a1 = "a) Evet"
        val b1 = "b) Hayır"

        val spanA1 = SpannableString(a1)
        spanA1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spanA1.setSpan(
            TypefaceSpan("satoshi_bold.otf"),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        spanA1.setSpan(
            AbsoluteSizeSpan(35),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val spanB1 = SpannableString(b1)
        spanB1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_purple)),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        spanB1.setSpan(
            TypefaceSpan("satoshi_bold.otf"),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        spanB1.setSpan(
            AbsoluteSizeSpan(35),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        return Pair(spanA1, spanB1)
    }

}