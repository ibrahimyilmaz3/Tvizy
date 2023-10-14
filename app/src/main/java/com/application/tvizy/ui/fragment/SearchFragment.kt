package com.application.tvizy.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.SearchAdapter
import com.application.tvizy.model.Search
import kotlinx.android.synthetic.main.fragment_search.*

@Deprecated("Moved to Explore Activity")
class SearchFragment : Fragment() {

    private lateinit var adapter: SearchAdapter
    private lateinit var imagesArrayList: ArrayList<Search>

    lateinit var imageID: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)

        rvSearch.layoutManager = layoutManager
        rvSearch.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapter = SearchAdapter(imagesArrayList)
        rvSearch.adapter = adapter
    }

    private fun dataInitialize() {
        /*imagesArrayList = arrayListOf()

        imageID = arrayListOf(
            R.drawable.channel,
            R.drawable.channel,
            R.drawable.channel,
            R.drawable.channel,
            R.drawable.channel,
            R.drawable.channel,
            R.drawable.channel,
            R.drawable.channel,
            R.drawable.channel
        )
        for (i in imageID.indices) {
            val images = Search(imageID[i])
            imagesArrayList.add(images)
        }*/
    }


}