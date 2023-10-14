package com.application.tvizy.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.ExploreAdapter
import com.application.tvizy.model.Explore
import kotlinx.android.synthetic.main.fragment_explore.*

@Deprecated("Moved to Explore Activity")
class ExploreFragment : Fragment() {

    private lateinit var adapter: ExploreAdapter
    private lateinit var imagesArrayList: ArrayList<Explore>

    lateinit var imageID: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        /*val layoutManager = FlexboxLayoutManager(context)
        layoutManager.flexWrap = FlexWrap.WRAP
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.alignItems = AlignItems.STRETCH
        rvExplore.layoutManager = layoutManager
        val adapter: RecyclerView.Adapter<*> = ExploreAdapter(imagesArrayList)
        rvExplore.adapter = adapter
        adapter.notifyDataSetChanged()*/

        /*val layoutManager = LinearLayoutManager(context)

        rvExplore.layoutManager = layoutManager
        rvExplore.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapter = ExploreAdapter(imagesArrayList)
        rvExplore.adapter = adapter*/

        val layoutManager = LinearLayoutManager(context)
        rvExplore.layoutManager = layoutManager

        adapter = ExploreAdapter(imagesArrayList)
        rvExplore.adapter = adapter

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
            val images = Explore(imageID[i])
            imagesArrayList.add(images)
        }
    }

}