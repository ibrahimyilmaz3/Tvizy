package com.application.tvizy.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.ReelsAdapter
import com.application.tvizy.model.Post
import kotlinx.android.synthetic.main.fragment_reel.*

class ReelFragment : Fragment() {

    private lateinit var adapter: ReelsAdapter
    private lateinit var imagesArrayList: ArrayList<Post>

    lateinit var imageID: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)

        rvReel.layoutManager = layoutManager
        rvReel.layoutManager = GridLayoutManager(context,3)

        adapter = ReelsAdapter()
        rvReel.adapter = adapter
    }

}