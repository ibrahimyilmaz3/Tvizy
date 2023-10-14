package com.application.tvizy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.model.City
import kotlinx.android.synthetic.main.item_dialog.view.*

class CityAdapter(val city: ArrayList<City>) :
    RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    private lateinit var context: Context
    val result= MutableLiveData<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_dialog, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            tvCountry.text = city[position].city

            setOnClickListener {
                result.value= tvCountry.text.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return city.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
