package com.application.tvizy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import kotlinx.android.synthetic.main.item_notification.view.*

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    private var icon = arrayListOf(
        "@ayşe adlı kullanıcı sizi takip etti.",
        "@yalıçapkını bu haftaki fragman yayında.",
        "@show yeni dizi Adım Farah bu Çarşamba ilk bölümüyle yayında.",
        "@güzelgünler BMW tam bakım hizmeti indirimde!",
        "@birperimasalı Bosch beyaz eşyada indirimde son hafta!.",
        "@sipahi Yeni bölümüyle 20.00'da ekranlarda!",
        "@ayşe adlı kullanıcı sizi takip etti.",
        "@yalıçapkını bu haftaki fragman yayında.",
        "@show yeni dizi Adım Farah bu Çarşamba ilk bölümüyle yayında.",
        "@güzelgünler BMW tam bakım hizmeti indirimde!",
        "@birperimasalı Bosch beyaz eşyada indirimde son hafta!.",
        "@sipahi Yeni bölümüyle 20.00'da ekranlarda!",
        "@ayşe adlı kullanıcı sizi takip etti.",
        "@yalıçapkını bu haftaki fragman yayında.",
        "@show yeni dizi Adım Farah bu Çarşamba ilk bölümüyle yayında.",
        "@güzelgünler BMW tam bakım hizmeti indirimde!",
        "@birperimasalı Bosch beyaz eşyada indirimde son hafta!.",
        "@sipahi Yeni bölümüyle 20.00'da ekranlarda!",
        "@ayşe adlı kullanıcı sizi takip etti.",
        "@yalıçapkını bu haftaki fragman yayında.",
        "@show yeni dizi Adım Farah bu Çarşamba ilk bölümüyle yayında.",
        "@güzelgünler BMW tam bakım hizmeti indirimde!",
        "@birperimasalı Bosch beyaz eşyada indirimde son hafta!.",
        "@sipahi Yeni bölümüyle 20.00'da ekranlarda!"
    )

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationAdapter.ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        context = parent.context
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: NotificationAdapter.ViewHolder, position: Int) {
        with(holder.itemView) {
            tvNot.text = icon[position]
        }
    }

    override fun getItemCount(): Int {
        return icon.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
