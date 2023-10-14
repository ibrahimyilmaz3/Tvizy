package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.Reel
import com.application.tvizy.service.PlayVideo
import com.application.tvizy.ui.activity.ChannelActivity
import com.application.tvizy.ui.activity.ProgramActivity
import com.application.tvizy.util.MainObject
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.item_reel.view.*

class ReelAdapter(private val reel: ArrayList<Reel>) :
    RecyclerView.Adapter<ReelAdapter.ViewHolder>() {

    private val list = ArrayList<Int>()

    private lateinit var context: Context

    private var selected = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReelAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_reel, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ReelAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            if (position == 1 || position == 4) {
                videoViewer.visibility = View.VISIBLE
                ivReel.visibility = View.GONE
                PlayVideo(
                    context,
                    "http://www.exit109.com/~dnn/clips/RW20seconds_2.mp4",
                    videoViewer
                )
                //PlayVideo(context, "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4", videoViewer)
            } else {
                videoViewer.visibility = View.GONE
                ivReel.visibility = View.VISIBLE
                blurViewFacade()
            }

            ivReel.setImageDrawable(ContextCompat.getDrawable(context, reel[position].image))
            ivChannel.setImageDrawable(ContextCompat.getDrawable(context,reel[position].channel))
            tvDescription.text = reel[position].description


            /*linearChannel.setOnClickListener {
                val intent = Intent(context, ChannelActivity::class.java)
                context.startActivity(intent)
            }*/

            if (list.contains(holder.absoluteAdapterPosition)) ivHeart.setImageDrawable(
                ContextCompat.getDrawable(context, R.drawable.heart_purple)
            ) else ivHeart.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.heart_white
                )
            )

            ivHeart.setOnClickListener {
                if (list.contains(holder.absoluteAdapterPosition)) list.remove(holder.absoluteAdapterPosition)
                else list.add(holder.absoluteAdapterPosition)
                notifyDataSetChanged()
            }

            cardSave.setOnClickListener {
                Toast.makeText(context, "Reel kaydedildi!", Toast.LENGTH_SHORT).show()
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

            MainObject.reelPosition = holder.absoluteAdapterPosition


            /////////


            if (reel[position].product != null) {
                rvProduct.layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                val adapterProduct = reel[position].product?.let { ProductAdapter(it) }
                rvProduct.adapter = adapterProduct

                rvProduct.visibility = View.VISIBLE
                ivBanner.visibility = View.GONE
            } else {
                rvProduct.visibility = View.GONE
                ivBanner.visibility = View.VISIBLE
            }

            val decorView = (context as AppCompatActivity).window.decorView
            val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
            val windowBackground = decorView.background
            blurView4.setupWith(rootView).setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(RenderScriptBlur(context))
                .setBlurRadius(10f)
                .setBlurAutoUpdate(false)
                .setHasFixedTransformationMatrix(false)

            tvDescription.setOnClickListener {
                val intent = Intent(context, ProgramActivity::class.java)
                context.startActivity(intent)
            }
            linearChannel.setOnClickListener {
                val intent = Intent(context, ChannelActivity::class.java)
                context.startActivity(intent)
            }

            cardHide.setOnClickListener {
                if (selected == 0) {
                    ivHide.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.d_arrow_up
                        )
                    )
                    tvHide.text = "Göster"
                    linearHide.visibility = View.GONE
                    selected = 1
                } else {
                    show()
                }
            }
            ivBanner.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://getir.com/"))
                context.startActivity(i)
            }
        }
    }

    private fun View.show() {
        ivHide.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.d_arrow_down))
        tvHide.text = "Gizle"
        linearHide.visibility = View.VISIBLE
        selected = 0
    }

    private fun View.blurViewFacade() {
        val decorView = (context as AppCompatActivity).window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background
        blurView.setupWith(rootView).setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(context))
            .setBlurRadius(10f)
            .setBlurAutoUpdate(false)
            .setHasFixedTransformationMatrix(false)
        blurView2.setupWith(rootView).setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(context))
            .setBlurRadius(10f)
            .setBlurAutoUpdate(false)
            .setHasFixedTransformationMatrix(false)
        blurView3.setupWith(rootView).setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(context))
            .setBlurRadius(10f)
            .setBlurAutoUpdate(false)
            .setHasFixedTransformationMatrix(false)
    }

    override fun getItemCount(): Int {
        return reel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)



}