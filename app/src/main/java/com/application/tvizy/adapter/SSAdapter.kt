package com.application.tvizy.adapter

import android.content.Context
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Survey
import kotlinx.android.synthetic.main.item_ss.view.*

@Deprecated("removed")
class SSAdapter(private val survey: ArrayList<Survey>) :
    RecyclerView.Adapter<SSAdapter.ViewHolder>() {

    private lateinit var context: Context
    private val list = ArrayList<Int>()
    private val list2 = ArrayList<Int>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SSAdapter.ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_ss, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: SSAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
//            ivSeries.setImageDrawable(ContextCompat.getDrawable(context, survey[position].series))
//            tvName.text = survey[position].name
            ivBackground.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    survey[position].background
                )
            )
            tvQuestion.text = survey[position].question
            tvOption1.text = survey[position].option1
            tvOption2.text = survey[position].option2

            tvOption1.setOnClickListener {
                if (!list2.contains(position)) {
                    list.add(position)
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
                    list.add(position)
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

/*
            linearSend.setOnClickListener {
                if (list.contains(position)) {
                    tvSend.text = "Gönderildi"
                    ivTick.visibility = View.VISIBLE
                    list2.add(position)
                } else {
                    Toast.makeText(context, "Lütfen bir seçeneğe dokunun!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            linearProgram.setOnClickListener {
                val intent = Intent(context, ProgramActivity::class.java)
                context.startActivity(intent)
            }
*/
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

    override fun getItemCount(): Int {
        return survey.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
