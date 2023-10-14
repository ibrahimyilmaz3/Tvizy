package com.application.tvizy.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.StreamsAdapter
import com.application.tvizy.model.Post
import kotlinx.android.synthetic.main.fragment_stream.*

class StreamFragment : Fragment() {

    private lateinit var adapter: StreamsAdapter
    private lateinit var imagesArrayList: ArrayList<Post>

    lateinit var imageID: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stream, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)

        rvStream.layoutManager = layoutManager

        adapter = StreamsAdapter()
        rvStream.adapter = adapter
    }


}