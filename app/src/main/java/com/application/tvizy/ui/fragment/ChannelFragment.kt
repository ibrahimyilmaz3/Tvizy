package com.application.tvizy.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.ChannelFollowAdapter
import com.application.tvizy.model.Channel
import kotlinx.android.synthetic.main.fragment_channel.*

class ChannelFragment : Fragment() {

    private lateinit var adapter: ChannelFollowAdapter
    private lateinit var imagesArrayList: ArrayList<Channel>

    lateinit var imageID: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_channel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)

        rvChannel.layoutManager = layoutManager
        rvChannel.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapter = ChannelFollowAdapter(imagesArrayList)
        rvChannel.adapter = adapter
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
            val images = Channel(imageID[i])
            imagesArrayList.add(images)
        }
    }

}