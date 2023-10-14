package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Story
import com.application.tvizy.ui.activity.ProgramActivity
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.item_ads.view.*
import kotlinx.android.synthetic.main.item_ads.view.cardShare
import kotlinx.android.synthetic.main.item_ads.view.ivProduct
import kotlinx.android.synthetic.main.item_comment_2.view.*
import kotlinx.android.synthetic.main.item_competition_2.view.*
import kotlinx.android.synthetic.main.item_question_2.view.*
import kotlinx.android.synthetic.main.item_survey_2.view.*

class PagerStory(private val context: Context, private val story: ArrayList<Story>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item_ads -> Ads(view.inflate(viewType, parent, false))
            R.layout.item_survey_2 -> Survey(view.inflate(viewType, parent, false))
            R.layout.item_competition_2 -> Competition(view.inflate(viewType, parent, false))
            R.layout.item_question_2 -> Question(view.inflate(viewType, parent, false))
            R.layout.item_comment_2 -> Comment(view.inflate(viewType, parent, false))
            else -> throw IllegalArgumentException()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (story[position].viewType) {
            "ads" -> {
                holder as Ads
                with(holder.itemView) {

                    ivStory.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].ads!!.image
                        )
                    )

                    ivChannel.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].ads!!.icon
                        )
                    )
                    tvName.text = story[position].ads!!.text

                    cardShare.setOnClickListener {
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "Paylaş")
                            type = "text/plain"
                        }

                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)
                    }

                    val decorView = (context as AppCompatActivity).window.decorView
                    val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
                    val windowBackground = decorView.background
                    blurView.setupWith(rootView).setFrameClearDrawable(windowBackground)
                        .setBlurAlgorithm(RenderScriptBlur(context))
                        .setBlurRadius(10f)
                        .setBlurAutoUpdate(false)
                        .setHasFixedTransformationMatrix(false)

                    ivProduct.setOnClickListener {
                        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nike.com/tr/"))
                        context.startActivity(i)
                    }

                }
            }
            "comment" -> {
                holder as Comment
                with(holder.itemView) {
                    ivChannel_comment.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].comment!!.channelIcon
                        )
                    )
                    tvChannel_comment.text = story[position].comment!!.channelName
                    ivSeries.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].comment!!.series
                        )
                    )
                    tvName_comment.text = story[position].comment!!.name
                    tvQuestion_comment.text = story[position].comment!!.comment

                    val decorView = (context as AppCompatActivity).window.decorView
                    val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
                    val windowBackground = decorView.background
                    blurView_comment.setupWith(rootView).setFrameClearDrawable(windowBackground)
                        .setBlurAlgorithm(RenderScriptBlur(context))
                        .setBlurRadius(10f)
                        .setBlurAutoUpdate(false)
                        .setHasFixedTransformationMatrix(false)
                }
            }
            "question" -> {
                holder as Question
                with(holder.itemView) {
                    ivChannel_question.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].question!!.channelIcon
                        )
                    )
                    tvChannel_question.text = story[position].question!!.channelName
                    ivChannel_question.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].question!!.channelIcon
                        )
                    )
                    tvChannel_question.text = story[position].question!!.channelName
                    ivSeries_question.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].question!!.series
                        )
                    )
                    ivBackground_question.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].question!!.background
                        )
                    )
                    ivBanner_question.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].question!!.banner
                        )
                    )
                    tvQuestion_question.text = story[position].question!!.question
                    tvName_question.text = story[position].question!!.name

                    val decorView = (context as AppCompatActivity).window.decorView
                    val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
                    val windowBackground = decorView.background
                    blurView_question.setupWith(rootView).setFrameClearDrawable(windowBackground)
                        .setBlurAlgorithm(RenderScriptBlur(context))
                        .setBlurRadius(10f)
                        .setBlurAutoUpdate(false)
                        .setHasFixedTransformationMatrix(false)

                }
            }
            "survey" -> {
                holder as Survey
                with(holder.itemView) {
                    ivChannel_survey.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].survey!!.channelIcon
                        )
                    )
                    tvChannel_survey.text = story[position].survey!!.channelName
                    ivSeries_survey.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].survey!!.series
                        )
                    )
                    tvName_survey.text = story[position].survey!!.name
                    ivBackground_survey.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].survey!!.background
                        )
                    )
                    ivBanner_survey.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].survey!!.banner
                        )
                    )
                    tvQuestion_survey.text = story[position].survey!!.question
                    tvOption1_survey.text = story[position].survey!!.option1
                    tvOption2_survey.text = story[position].survey!!.option2

                    linearProgram_survey.setOnClickListener {
                        val intent = Intent(context, ProgramActivity::class.java)
                        context.startActivity(intent)
                    }
                    cardShare_survey.setOnClickListener {
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "Paylaş")
                            type = "text/plain"
                        }

                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)
                    }
                    ivBanner_survey.setOnClickListener {

                        val i = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.maisonmargiela.com/wx/")
                        )
                        context.startActivity(i)
                    }

                    val decorView = (context as AppCompatActivity).window.decorView
                    val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
                    val windowBackground = decorView.background
                    blurView_survey.setupWith(rootView).setFrameClearDrawable(windowBackground)
                        .setBlurAlgorithm(RenderScriptBlur(context))
                        .setBlurRadius(10f)
                        .setBlurAutoUpdate(false)
                        .setHasFixedTransformationMatrix(false)
                }
            }
            "competition" -> {
                holder as Competition
                with(holder.itemView) {
                    ivChannel_competition.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].competition!!.channelIcon
                        )
                    )
                    tvChannel_competition.text = story[position].competition!!.channelName
                    ivSeries_competition.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].competition!!.series
                        )
                    )
                    tvName_competition.text = story[position].competition!!.name
                    ivBackground_competition.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            story[position].competition!!.background
                        )
                    )
                    tvQuestion1_competition.text = story[position].competition!!.question1
                    tvOption1_competition.text = story[position].competition!!.option1a
                    tvOption2_competition.text = story[position].competition!!.option1b

                    tvQuestion2_competition.text = story[position].competition!!.question2
                    tvOption3_competition.text = story[position].competition!!.option2a
                    tvOption4_competition.text = story[position].competition!!.option2b

                    tvQuestion3_competition.text = story[position].competition!!.question3
                    tvOption5_competition.text = story[position].competition!!.option3a
                    tvOption6_competition.text = story[position].competition!!.option3b

                    linearProgram_competition.setOnClickListener {
                        val intent = Intent(context, ProgramActivity::class.java)
                        context.startActivity(intent)
                    }
                    cardShare_competition.setOnClickListener {
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "Paylaş")
                            type = "text/plain"
                        }

                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)
                    }

                    val decorView = (context as AppCompatActivity).window.decorView
                    val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
                    val windowBackground = decorView.background
                    blurView_competition.setupWith(rootView).setFrameClearDrawable(windowBackground)
                        .setBlurAlgorithm(RenderScriptBlur(context))
                        .setBlurRadius(10f)
                        .setBlurAutoUpdate(false)
                        .setHasFixedTransformationMatrix(false)
                }
            }
            else -> throw IllegalArgumentException()
        }
    }


    override fun getItemCount(): Int = story.size

    override fun getItemViewType(position: Int): Int {

        return when (story[position].viewType) {
            "ads" -> {
                R.layout.item_ads
            }
            "survey" -> {
                R.layout.item_survey_2
            }
            "competition" -> {
                R.layout.item_competition_2
            }
            "question" -> {
                R.layout.item_question_2
            }
            "comment" -> {
                R.layout.item_comment_2
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    inner class Ads(view: View) : RecyclerView.ViewHolder(view)
    inner class Survey(view: View) : RecyclerView.ViewHolder(view)
    inner class Competition(view: View) : RecyclerView.ViewHolder(view)
    inner class Question(view: View) : RecyclerView.ViewHolder(view)
    inner class Comment(view: View) : RecyclerView.ViewHolder(view)

}