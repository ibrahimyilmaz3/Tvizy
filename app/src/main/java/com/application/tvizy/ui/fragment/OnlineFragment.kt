package com.application.tvizy.ui.fragment

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.application.tvizy.R
import com.application.tvizy.adapter.OnlineAdapter
import com.application.tvizy.model.*
import kotlinx.android.synthetic.main.fragment_online.*

class OnlineFragment : Fragment() {

    private lateinit var adapter: OnlineAdapter
    var online = ArrayList<Online>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_online, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        optionSender()
        dataSurvey()
        dataCompetition()
        dataQuestion()
        dataComment()
        dataVideo()

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvOnline)

        rvOnline.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        online.shuffle()
        adapter = OnlineAdapter(online)
        rvOnline.adapter = adapter
    }

    private fun dataVideo() {
        online.add(
            Online(
                null,
                null,
                null,
                null,
                Video("http://www.exit109.com/~dnn/clips/RW20seconds_2.mp4", R.drawable.banner_2), viewType = "video"
            )
        )
    }

    private fun dataComment() {
        online.add(
            Online(
                null,
                null,
                null,
                Comment(
                    R.drawable.example_series,
                    "Adım Farah - Yorum gönder",
                    R.drawable.series_1,
                    R.drawable.banner_2, "Fatma Mehmet'e kızgın!"
                ),
                null, viewType = "comment"
            )
        )
        online.add(
            Online(
                null,
                null,
                null,
                Comment(
                    R.drawable.example_series_2,
                    "Güzel Günler - Yorum gönder",
                    R.drawable.series_2,
                    R.drawable.banner_3, "Selim Mehmet'e kızgın!"
                ),
                null, viewType = "comment"
            )
        )
        online.add(
            Online(
                null,
                null,
                null,
                Comment(
                    R.drawable.example_series_3,
                    "Elif - Yorum gönder",
                    R.drawable.series_3,
                    R.drawable.banner_4, "Gizem Mehmet'e kızgın!"
                ),
                null, viewType = "comment"
            )
        )
    }

    private fun dataQuestion() {
        online.add(
            Online(
                null,
                null,
                Question(
                    R.drawable.example_series,
                    "Adım Farah - Soru gönder",
                    R.drawable.series_1,
                    R.drawable.banner_2, "Fatih'in en sevdiği renk sence nedir?"
                ),
                null,
                null, viewType = "question"
            )
        )
        online.add(
            Online(
                null,
                null,
                Question(
                    R.drawable.example_series_2,
                    "Güzel Günler - Soru gönder",
                    R.drawable.series_2,
                    R.drawable.banner_3, "Mehmet'in en sevdiği renk sence nedir?"
                ),
                null,
                null, viewType = "question"
            )
        )
        online.add(
            Online(
                null,
                null,
                Question(
                    R.drawable.example_series_3,
                    "Elif - Soru gönder",
                    R.drawable.series_3,
                    R.drawable.banner_4, "Selin'in en sevdiği renk sence nedir?"
                ),
                null,
                null, viewType = "question"
            )
        )
    }

    private fun dataCompetition() {

        val (spanA1, spanB1) = compOption()

        online.add(
            Online(
                null, Competition(
                    R.drawable.example_series,
                    "Adım Farah - Günün yarışması",
                    R.drawable.series_1,
                    R.drawable.banner_2,
                    "Fatih'in en sevdiği renk hangisi?",
                    spanA1,
                    spanB1, "Mehmet'in en sevdiği renk hangisi?",
                    spanA1,
                    spanB1, "Hasan'ın en sevdiği renk hangisi?",
                    spanA1,
                    spanB1,
                ), null, null, null, viewType = "competition"
            )
        )

        online.add(
            Online(
                null, Competition(
                    R.drawable.example_series_2,
                    "Güzel Günler - Günün yarışması",
                    R.drawable.series_2,
                    R.drawable.banner_2,
                    "Ayşe'nin en sevdiği renk hangisi?",
                    spanA1,
                    spanB1, "Fatma'nın en sevdiği renk hangisi?",
                    spanA1,
                    spanB1, "Beril'in en sevdiği renk hangisi?",
                    spanA1,
                    spanB1,
                ), null, null, null, viewType = "competition"
            )
        )

        online.add(
            Online(
                null, Competition(
                    R.drawable.example_series_3,
                    "Elif - Günün yarışması",
                    R.drawable.series_3,
                    R.drawable.banner_2,
                    "Ayşe'nin en sevdiği akrabası hangisi?",
                    spanA1,
                    spanB1, "Mehmet'in en sevdiği akrabası hangisi?",
                    spanA1,
                    spanB1, "Hasan'ın en sevdiği akrabası hangisi?",
                    spanA1,
                    spanB1,
                ), null, null, null, viewType = "competition"
            )
        )
    }

    private fun dataSurvey() {

        val (spanA1, spanB1) = optionSender()

        online.add(
            Online(
                Survey(
                    R.drawable.example_series,
                    "Adım Farah",
                    R.drawable.series_1,
                    R.drawable.banner_2,
                    "Sence Fatih haklı mı?",
                    spanA1,
                    spanB1
                ), null, null, null, null, viewType = "survey"
            )
        )
        online.add(
            Online(
                Survey(
                    R.drawable.example_series_2,
                    "Güzel Günler",
                    R.drawable.series_2,
                    R.drawable.banner_3,
                    "Sence Mehmet haklı mı?",
                    spanA1,
                    spanB1
                ), null, null, null, null, viewType = "survey"
            )
        )
        online.add(
            Online(
                Survey(
                    R.drawable.example_series_3,
                    "Elif",
                    R.drawable.series_3,
                    R.drawable.banner_4,
                    "Sence Elif haklı mı?",
                    spanA1,
                    spanB1
                ), null, null, null, null, viewType = "survey"
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
            AbsoluteSizeSpan(35),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        val spanB1 = SpannableString(b1)
        spanB1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_purple)),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        spanB1.setSpan(
            AbsoluteSizeSpan(35),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        return Pair(spanA1, spanB1)
    }

    private fun compOption(): Pair<SpannableString, SpannableString> {
        val a1 = "a) Sarı"
        val b1 = "b) Mavi"

        val spanA1 = SpannableString(a1)
        spanA1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
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
            AbsoluteSizeSpan(35),
            0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        return Pair(spanA1, spanB1)
    }

}