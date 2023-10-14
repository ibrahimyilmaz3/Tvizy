package com.application.tvizy.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.ExploreAdapter
import com.application.tvizy.adapter.FocusAdapter
import com.application.tvizy.adapter.SearchAdapter
import com.application.tvizy.model.Explore
import com.application.tvizy.model.Search
import com.application.tvizy.service.Tools
import com.application.tvizy.util.BaseAppCompatActivity
import com.application.tvizy.util.funClearAnimationIntent
import com.application.tvizy.util.navigation
import kotlinx.android.synthetic.main.activity_explore.*

class ExploreActivity : BaseAppCompatActivity() {


    private var exploreList = ArrayList<Explore>()
    private var searchList = ArrayList<Search>()
    private val searchList2 = ArrayList<Search>()
    private val searchList3 = ArrayList<Search>()

    private var backPressedOnce = false
    private var doubleBackPressedTime: Long = 0


    override fun onBackPressed() {
        etSearch.clearFocus()
        etSearch.setText("")
        rvExplore.visibility = View.VISIBLE
        rvSearch.visibility = View.INVISIBLE
        rvFocus.visibility = View.INVISIBLE
        ivClear.visibility = View.INVISIBLE
        val adapterSearch = SearchAdapter(searchList)
        rvSearch.adapter = adapterSearch

        if (backPressedOnce) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - doubleBackPressedTime < 2000) {
                funClearAnimationIntent(HomeActivity())
            } else {
                backPressedOnce = false
            }
        } else {
            backPressedOnce = true
            doubleBackPressedTime = System.currentTimeMillis()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        navigation("explorer")
        dataExplore()
        dataSearch()
        dataSearch2()

        rvExplore.layoutManager = LinearLayoutManager(this)
        val adapterEx = ExploreAdapter(exploreList)
        rvExplore.adapter = adapterEx

        rvSearch.layoutManager = LinearLayoutManager(this)
        val adapterSearch = SearchAdapter(searchList)
        rvSearch.adapter = adapterSearch

        rvFocus.layoutManager = LinearLayoutManager(this)
        rvFocus.adapter = FocusAdapter(searchList3)

        etSearch.setOnFocusChangeListener { view, b ->
            if (etSearch.isFocused || etSearch.text.toString().isBlank()) {
                rvFocus.visibility = View.VISIBLE
                rvExplore.visibility = View.INVISIBLE
                rvSearch.visibility = View.INVISIBLE
            }
        }

        etSearch.addTextChangedListener {
            when (etSearch.text.toString().length) {
                0 -> {
                    rvFocus.visibility = View.VISIBLE
                    rvExplore.visibility = View.INVISIBLE
                    rvSearch.visibility = View.INVISIBLE

                    /*rvExplore.visibility = View.VISIBLE
                    rvSearch.visibility = View.INVISIBLE
                    rvFocus.visibility = View.INVISIBLE
                    ivClear.visibility = View.INVISIBLE
                    val adapterSearch = SearchAdapter(searchList)
                    rvSearch.adapter = adapterSearch*/
                }
                else -> {
                    rvExplore.visibility = View.INVISIBLE
                    rvSearch.visibility = View.VISIBLE
                    rvFocus.visibility = View.INVISIBLE
                    ivClear.visibility = View.VISIBLE

                    searchList2.clear()
                    for (i in searchList) {
                        if (i.name.contains("${etSearch.text}", true)) {
                            searchList2.add(i)
                        }
                    }
                    val adapterSearch = SearchAdapter(searchList2)
                    rvSearch.adapter = adapterSearch
                }
            }
        }

        ivClear.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            etSearch.text.clear()
        }

    }

    /*private fun transaction(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }*/

    private fun dataExplore() {
        exploreList.add(Explore(R.drawable.fake_reel_5))
        exploreList.add(Explore(R.drawable.fake_reel_5))
        exploreList.add(Explore(R.drawable.fake_reel_5))
        exploreList.add(Explore(R.drawable.fake_reel_5))
        exploreList.add(Explore(R.drawable.fake_reel_5))
    }

    private fun dataSearch() {
        searchList.add(Search(R.drawable.example_profile_11, "Ayşe", "@ayşe"))
        searchList.add(Search(R.drawable.show_tv, "Show TV", "@showtv"))
        searchList.add(Search(R.drawable.example_profile_2, "Selin", "@selin"))
        searchList.add(Search(R.drawable.star_tv, "Star TV", "@startv"))
        searchList.add(Search(R.drawable.example_profile_3, "Beril", "@beril"))
        searchList.add(Search(R.drawable.atv, "ATV", "@atv"))
        searchList.add(Search(R.drawable.example_profile_4, "Berk", "@berk"))
        searchList.add(Search(R.drawable.kanal_d, "Kanal D", "@kanald"))
        searchList.add(Search(R.drawable.example_profile_5, "Mert", "@mert"))
        searchList.add(Search(R.drawable.example_profile_6, "Mehmet", "@mehmet"))
        searchList.add(Search(R.drawable.example_profile_7, "Can", "@can"))
        searchList.add(Search(R.drawable.example_profile_8, "Alican", "@alican"))
        searchList.add(Search(R.drawable.example_profile_9, "Hamed", "@hamed"))
        searchList.add(Search(R.drawable.example_profile_10, "Taylan", "@taylan"))
    }

    private fun dataSearch2() {
        searchList3.add(Search(R.drawable.example_profile_11, "Ayşe", "@ayşe"))
        searchList3.add(Search(R.drawable.show_tv, "Show TV", "@showtv"))
        searchList3.add(Search(R.drawable.example_profile_2, "Selin", "@selin"))
        searchList3.add(Search(R.drawable.star_tv, "Star TV", "@startv"))
        searchList3.add(Search(R.drawable.example_profile_3, "Beril", "@beril"))
        searchList3.add(Search(R.drawable.atv, "ATV", "@atv"))
        searchList3.add(Search(R.drawable.example_profile_4, "Berk", "@berk"))
        searchList3.add(Search(R.drawable.kanal_d, "Kanal D", "@kanald"))
        searchList3.add(Search(R.drawable.example_profile_5, "Mert", "@mert"))
        searchList3.add(Search(R.drawable.example_profile_6, "Mehmet", "@mehmet"))
        searchList3.add(Search(R.drawable.example_profile_7, "Can", "@can"))
        searchList3.add(Search(R.drawable.example_profile_8, "Alican", "@alican"))
        searchList3.add(Search(R.drawable.example_profile_9, "Hamed", "@hamed"))
        searchList3.add(Search(R.drawable.example_profile_10, "Taylan", "@taylan"))
    }
}