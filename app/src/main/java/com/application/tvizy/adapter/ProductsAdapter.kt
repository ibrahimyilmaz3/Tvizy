package com.application.tvizy.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
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

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    private var program = arrayListOf(
        R.drawable.black_jacket,
        R.drawable.green_dress,
        R.drawable.sleeveless,
        R.drawable.red_dress,
        R.drawable.suit_shoe,
        R.drawable.red_jacket,
        R.drawable.jean,
        R.drawable.suit_jacket,
        R.drawable.lumber_shirt,
        R.drawable.gray_tshirt,
        R.drawable.suit_pant,
        R.drawable.shirt,
        R.drawable.lady_shoe,
        R.drawable.lady_dress_shoe,
        R.drawable.casual_shoe
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {

            ivProduct.setImageDrawable(
                ContextCompat.getDrawable(
                    (context as AppCompatActivity),
                    program[position]
                )
            )

            setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebay.com/"))
                context.startActivity(i)
            }

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
        return program.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}