package com.application.tvizy.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.SponsorAdapter
import com.application.tvizy.model.Sponsor
import kotlinx.android.synthetic.main.fragment_sponsor.*

class SponsorFragment : Fragment() {

    private lateinit var adapter: SponsorAdapter
    private lateinit var imagesArrayList: ArrayList<Sponsor>

    lateinit var imageID: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sponsor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)

        rvSponsor.layoutManager = layoutManager
        rvSponsor.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapter = SponsorAdapter()
        rvSponsor.adapter = adapter
    }

    private fun dataInitialize() {
        imagesArrayList = arrayListOf()

        imageID = arrayListOf(
            R.drawable.show_tv,
            R.drawable.show_tv,
            R.drawable.show_tv,
            R.drawable.show_tv,
            R.drawable.show_tv,
            R.drawable.show_tv,
            R.drawable.show_tv,
            R.drawable.show_tv,
            R.drawable.show_tv
        )
        for (i in imageID.indices) {
            val images = Sponsor(imageID[i])
            imagesArrayList.add(images)
        }
    }

}