package com.application.tvizy.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.FavoritesAdapter
import com.application.tvizy.model.Favorites
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : Fragment() {

    private lateinit var adapter: FavoritesAdapter
    private lateinit var imagesArrayList: ArrayList<Favorites>

    lateinit var imageID: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)

        rvFavorites.layoutManager = layoutManager
        rvFavorites.layoutManager = GridLayoutManager(context, 2)

        adapter = FavoritesAdapter(imagesArrayList)
        rvFavorites.adapter = adapter
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
            val images = Favorites(imageID[i])
            imagesArrayList.add(images)
        }
    }

}