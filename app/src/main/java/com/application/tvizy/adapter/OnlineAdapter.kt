package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Online
import com.application.tvizy.service.PlayVideo
import com.application.tvizy.ui.activity.ProgramActivity
import eightbitlab.com.blurview.BlurViewFacade
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.item_comment.view.*
import kotlinx.android.synthetic.main.item_competition.view.*
import kotlinx.android.synthetic.main.item_question.view.*
import kotlinx.android.synthetic.main.item_survey.view.*
import kotlinx.android.synthetic.main.item_video.view.*

class OnlineAdapter(private val online: ArrayList<Online>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var context: Context
    private val list1 = ArrayList<Int>()
    private val list2 = ArrayList<Int>()

    private val list3 = ArrayList<Int>()
    private val list4 = ArrayList<Int>()
    private val list5 = ArrayList<Int>()
    private val list6 = ArrayList<Int>()
    private val list7 = ArrayList<Int>()
    private val list8 = ArrayList<Int>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item_video -> Video(view.inflate(viewType, parent, false))
            R.layout.item_survey -> Survey(view.inflate(viewType, parent, false))
            R.layout.item_competition -> Competition(view.inflate(viewType, parent, false))
            R.layout.item_question -> Question(view.inflate(viewType, parent, false))
            R.layout.item_comment -> Comment(view.inflate(viewType, parent, false))
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (online[position].viewType) {
            "video" -> {
                holder as Video
                with(holder.itemView) {
                    PlayVideo(
                        context,
                        online[position].video!!.url,
                        videoViewer
                    )

                    ivBanner_video.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            online[position].video!!.banner
                        )
                    )
                    ivBanner_video.setOnClickListener {

                        val i = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.maisonmargiela.com/wx/")
                        )
                        context.startActivity(i)
                    }
                }

            }

            "survey" -> {
                survey(holder, position)
            }
            "competition" -> {
                holder as Competition
                with(holder.itemView) {
                    blurViewFacade_comp()
                    ivSeries_comp.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            online[position].competition!!.series
                        )
                    )
                    competeTitle_comp.text = online[position].competition!!.name
                    ivBackground_comp.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            online[position].competition!!.background
                        )
                    )
                    tvQuestion1_comp.text = online[position].competition!!.question1
                    tvOption1_comp.text = online[position].competition!!.option1a
                    tvOption2_comp.text = online[position].competition!!.option1b

                    tvQuestion2_comp.text = online[position].competition!!.question2
                    tvOption3_comp.text = online[position].competition!!.option2a
                    tvOption4_comp.text = online[position].competition!!.option2b

                    tvQuestion3_comp.text = online[position].competition!!.question3
                    tvOption5_comp.text = online[position].competition!!.option3a
                    tvOption6_comp.text = online[position].competition!!.option3b

                    tvOption1_comp.setOnClickListener {
                        if (!list4.contains(position)) {
                            list3.add(position)
                            clear_comp1(position)
                            tvOption1_comp.background =
                                ContextCompat.getDrawable(context, R.drawable.round_9_white_corner)
                            val text3 = tvOption1_comp.text.toSpannable()
                            text3.setSpan(
                                ForegroundColorSpan(ContextCompat.getColor(context, R.color.green)),
                                0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            tvOption1_comp.text = text3
                        }
                    }
                    tvOption2_comp.setOnClickListener {
                        if (!list4.contains(position)) {
                            list3.add(position)
                            clear_comp1(position)
                            tvOption2_comp.background =
                                ContextCompat.getDrawable(context, R.drawable.round_9_white_corner)
                            val text4 = tvOption2_comp.text.toSpannable()
                            text4.setSpan(
                                ForegroundColorSpan(ContextCompat.getColor(context, R.color.green)),
                                0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            tvOption2_comp.text = text4
                        }
                    }

                    tvOption3_comp.setOnClickListener {
                        if (!list4.contains(position)) {
                            list5.add(position)
                            clear_comp2(position)
                            tvOption3_comp.background =
                                ContextCompat.getDrawable(context, R.drawable.round_9_white_corner)
                            val text5 = tvOption3_comp.text.toSpannable()
                            text5.setSpan(
                                ForegroundColorSpan(ContextCompat.getColor(context, R.color.green)),
                                0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            tvOption3_comp.text = text5
                        }
                    }
                    tvOption4_comp.setOnClickListener {
                        if (!list4.contains(position)) {
                            list5.add(position)
                            clear_comp2(position)
                            tvOption4_comp.background =
                                ContextCompat.getDrawable(context, R.drawable.round_9_white_corner)
                            val text6 = tvOption4_comp.text.toSpannable()
                            text6.setSpan(
                                ForegroundColorSpan(ContextCompat.getColor(context, R.color.green)),
                                0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            tvOption4_comp.text = text6
                        }
                    }

                    tvOption5_comp.setOnClickListener {
                        if (!list4.contains(position)) {
                            list6.add(position)
                            clear_comp3(position)
                            tvOption5_comp.background =
                                ContextCompat.getDrawable(context, R.drawable.round_9_white_corner)
                            val text7 = tvOption5_comp.text.toSpannable()
                            text7.setSpan(
                                ForegroundColorSpan(ContextCompat.getColor(context, R.color.green)),
                                0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            tvOption5_comp.text = text7
                        }
                    }
                    tvOption6_comp.setOnClickListener {
                        if (!list4.contains(position)) {
                            list6.add(position)
                            clear_comp3(position)
                            tvOption6_comp.background =
                                ContextCompat.getDrawable(context, R.drawable.round_9_white_corner)
                            val text6 = tvOption6_comp.text.toSpannable()
                            text6.setSpan(
                                ForegroundColorSpan(ContextCompat.getColor(context, R.color.green)),
                                0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            tvOption6_comp.text = text6
                        }
                    }

                    linearSend_comp.setOnClickListener {
                        if (list3.contains(position) && list5.contains(position) && list6.contains(
                                position
                            )
                        ) {
                            tvSend_comp.text = "Gönderildi"
                            ivTick_comp.visibility = View.VISIBLE
                            list4.add(position)
                        } else {
                            Toast.makeText(
                                context,
                                "Lütfen bütün soruları cevaplayın!",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }

                    linearProgram_comp.setOnClickListener {
                        val intent = Intent(context, ProgramActivity::class.java)
                        context.startActivity(intent)
                    }
                    cardShare_comp.setOnClickListener {
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "Paylaş")
                            type = "text/plain"
                        }

                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)
                    }
                }
            }
            "question" -> {
                holder as Question
                with(holder.itemView) {
                    ivSeries_question.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            online[position].question!!.series
                        )
                    )
                    tvName_question.text = online[position].question!!.name
                    ivBackground_question.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            online[position].question!!.background
                        )
                    )
                    ivBanner_question.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            online[position].question!!.banner
                        )
                    )
                    tvQuestion_question.text = online[position].question!!.question

                    linearSend_question.setOnClickListener {
                        if (etAnswer_question.text.toString().isEmpty()) {
                            Toast.makeText(context, "Lütfen bir soru yazın!", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            tvSend_question.text = "Gönderildi"
                            ivTick_question.visibility = View.VISIBLE
                            etAnswer_question.isEnabled = false
                        }
                    }
                }
            }
            "comment" -> {
                holder as Comment
                with(holder.itemView) {
                    ivSeries_comment.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            online[position].comment!!.series
                        )
                    )
                    tvName_comment.text = online[position].comment!!.name
                    ivBackground_comment.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            online[position].comment!!.background
                        )
                    )
                    ivBanner_comment.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            online[position].comment!!.banner
                        )
                    )
                    tvQuestion_comment.text = online[position].comment!!.comment

                    linearSend_comment.setOnClickListener {
                        if (etAnswer_comment.text.toString().isEmpty()) {
                            Toast.makeText(context, "Lütfen bir yorum yazın!", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            tvSend_comment.text = "Gönderildi"
                            ivTick_comment.visibility = View.VISIBLE
                            etAnswer_comment.isEnabled = false
                        }
                    }

                    blurViewFacade_comment()
                }
            }
            else -> throw IllegalArgumentException()
        }
    }

    private fun OnlineAdapter.survey(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        holder as Survey
        with(holder.itemView) {
            blurViewFacade()
            ivSeries.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    online[position].survey!!.series
                )
            )
            tvName.text = online[position].survey!!.name
            ivBackground.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    online[position].survey!!.background
                )
            )
            ivBanner.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    online[position].survey!!.banner
                )
            )
            tvQuestion.text = online[position].survey!!.question
            tvOption1.text = online[position].survey!!.option1
            tvOption2.text = online[position].survey!!.option2

            tvOption1.setOnClickListener {
                if (!list2.contains(position)) {
                    list1.add(position)
                    clear(position)
                    tvOption1.background =
                        ContextCompat.getDrawable(context, R.drawable.round_9_white_corner)
                    val text3 = tvOption1.text.toSpannable()
                    text3.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.green)),
                        0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    tvOption1.text = text3
                }
            }
            tvOption2.setOnClickListener {
                if (!list2.contains(position)) {
                    list1.add(position)
                    clear(position)
                    tvOption2.background =
                        ContextCompat.getDrawable(context, R.drawable.round_9_white_corner)
                    val text4 = tvOption2.text.toSpannable()
                    text4.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.green)),
                        0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    tvOption2.text = text4
                }
            }

            linearSend.setOnClickListener {
                if (list1.contains(position)) {
                    tvSend.text = "Gönderildi"
                    ivTick.visibility = View.VISIBLE
                    list2.add(position)
                } else {
                    Toast.makeText(
                        context,
                        "Lütfen bir seçeneğe dokunun!",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            linearProgram.setOnClickListener {
                val intent = Intent(context, ProgramActivity::class.java)
                context.startActivity(intent)
            }
            cardShare.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Paylaş")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                context.startActivity(shareIntent)
            }
            ivBanner.setOnClickListener {
                when (position) {
                    0 -> {
                        val i = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.maisonmargiela.com/wx/")
                        )
                        context.startActivity(i)
                    }
                    1 -> {
                        val i =
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://www.volvocars.com/tr/")
                            )
                        context.startActivity(i)
                    }
                    2 -> {
                        val i = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.bosch.com.tr/")
                        )
                        context.startActivity(i)
                    }
                }
            }
        }
    }

    private fun View.clear(position: Int) {

        val text1 = tvOption1.text.toSpannable()
        text1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvOption1.text = text1

        val text2 = tvOption2.text.toSpannable()
        text2.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvOption2.text = text2

        tvOption1.background = ContextCompat.getDrawable(context, R.drawable.round_9_white)
        tvOption2.background = ContextCompat.getDrawable(context, R.drawable.round_9_white)
    }

    private fun View.clear_comp1(position: Int) {

        val text1 = tvOption1_comp.text.toSpannable()
        text1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvOption1_comp.text = text1

        val text2 = tvOption2_comp.text.toSpannable()
        text2.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvOption2_comp.text = text2

        tvOption1_comp.background = ContextCompat.getDrawable(context, R.drawable.round_9_white)
        tvOption2_comp.background = ContextCompat.getDrawable(context, R.drawable.round_9_white)
    }

    private fun View.clear_comp2(position: Int) {

        val text1 = tvOption3_comp.text.toSpannable()
        text1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvOption3_comp.text = text1

        val text2 = tvOption4_comp.text.toSpannable()
        text2.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvOption4_comp.text = text2

        tvOption3_comp.background = ContextCompat.getDrawable(context, R.drawable.round_9_white)
        tvOption4_comp.background = ContextCompat.getDrawable(context, R.drawable.round_9_white)
    }

    private fun View.clear_comp3(position: Int) {

        val text1 = tvOption5_comp.text.toSpannable()
        text1.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvOption5_comp.text = text1

        val text2 = tvOption5_comp.text.toSpannable()
        text2.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, R.color.light_purple)),
            0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvOption5_comp.text = text2

        tvOption5_comp.background = ContextCompat.getDrawable(context, R.drawable.round_9_white)
        tvOption5_comp.background = ContextCompat.getDrawable(context, R.drawable.round_9_white)
    }

    private fun View.blurViewFacade(): BlurViewFacade? {
        val decorView = (context as AppCompatActivity).window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background
        return blurView.setupWith(rootView).setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(context))
            .setBlurRadius(10f)
            .setBlurAutoUpdate(false)
            .setHasFixedTransformationMatrix(false)
    }

    private fun View.blurViewFacade_comp(): BlurViewFacade? {
        val decorView = (context as AppCompatActivity).window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background
        return blurView_comp.setupWith(rootView).setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(context))
            .setBlurRadius(10f)
            .setBlurAutoUpdate(false)
            .setHasFixedTransformationMatrix(false)
    }

    private fun View.blurViewFacade_comment(): BlurViewFacade? {
        val decorView = (context as AppCompatActivity).window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background
        return blurView_comment.setupWith(rootView).setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(context))
            .setBlurRadius(10f)
            .setBlurAutoUpdate(false)
            .setHasFixedTransformationMatrix(false)
    }

    override fun getItemCount(): Int {
        return online.size
    }

    override fun getItemViewType(position: Int): Int {

        return when (online[position].viewType) {
            "video" -> {
                R.layout.item_video
            }
            "survey" -> {
                R.layout.item_survey
            }
            "competition" -> {
                R.layout.item_competition
            }
            "question" -> {
                R.layout.item_question
            }
            "comment" -> {
                R.layout.item_comment
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    inner class Video(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class Survey(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class Competition(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class Question(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class Comment(itemView: View) : RecyclerView.ViewHolder(itemView)

}
