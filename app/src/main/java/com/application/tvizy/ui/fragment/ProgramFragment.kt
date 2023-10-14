package com.application.tvizy.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.ProgramsAdapter
import com.application.tvizy.model.Post
import kotlinx.android.synthetic.main.fragment_program.*

class ProgramFragment : Fragment() {

    private lateinit var adapter: ProgramsAdapter
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
        return inflater.inflate(R.layout.fragment_program, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(context, 2)

        rvProgram.layoutManager = layoutManager

        adapter = ProgramsAdapter()
        rvProgram.adapter = adapter
    }


}