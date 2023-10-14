package com.application.tvizy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import eightbitlab.com.blurview.BlurViewFacade
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.item_product.view.*

class Product2Adapter : RecyclerView.Adapter<Product2Adapter.ViewHolder>() {

    private var product = arrayListOf(
        Triple(R.drawable.black_jacket, R.drawable.green_dress, R.drawable.sleeveless),
        Triple(R.drawable.red_dress, R.drawable.suit_shoe, R.drawable.red_jacket),
        Triple(R.drawable.jean, R.drawable.suit_jacket, R.drawable.lumber_shirt),
        Triple(R.drawable.gray_tshirt, R.drawable.suit_pant, R.drawable.shirt),
        Triple(R.drawable.lady_shoe, R.drawable.lady_dress_shoe, R.drawable.casual_shoe)
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Product2Adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Product2Adapter.ViewHolder, position: Int) {
        with(holder.itemView) {

            ivProduct.setImageDrawable(
                ContextCompat.getDrawable(
                    (context as AppCompatActivity),
                    product[position].second
                )
            )

            blurViewFacade()

        }
    }

    private fun View.blurViewFacade(): BlurViewFacade? {
        val decorView = (context as AppCompatActivity).window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background
        return blurView.setupWith(rootView).setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(context as AppCompatActivity))
            .setBlurRadius(10f)
            .setBlurAutoUpdate(false)
            .setHasFixedTransformationMatrix(false)
    }

    override fun getItemCount(): Int {
        return product.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}