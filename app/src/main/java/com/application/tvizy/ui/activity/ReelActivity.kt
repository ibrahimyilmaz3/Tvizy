package com.application.tvizy.ui.activity

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.application.tvizy.R
import com.application.tvizy.adapter.ReelAdapter
import com.application.tvizy.model.Product
import com.application.tvizy.model.Reel
import com.application.tvizy.util.funClearAnimationIntent
import com.application.tvizy.util.navigation
import kotlinx.android.synthetic.main.activity_reel.*
import kotlinx.android.synthetic.main.navigation.*

class ReelActivity : AppCompatActivity() {

    private var layoutManagerReel: RecyclerView.LayoutManager? = null

    private val snapHelper = PagerSnapHelper()

    private val reel = ArrayList<Reel>()
    private val product1 = ArrayList<Product>()
    private val product2 = ArrayList<Product>()

    override fun onBackPressed() {
        funClearAnimationIntent(HomeActivity())
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reel)
        transparentStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        navigation("reel")
        rv()

        linearBottom.background = ContextCompat.getDrawable(this, R.color.black)
        ivReel.setColorFilter(ContextCompat.getColor(this, R.color.white))
        tvReel.setTextColor(ContextCompat.getColor(this, R.color.white))


    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun rv() {

        dataInitialize()

        snapHelper.attachToRecyclerView(rvReel)
        layoutManagerReel = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvReel.layoutManager = layoutManagerReel
        val adapterReel = ReelAdapter(reel)
        rvReel.adapter = adapterReel




    }

    private fun transparentStatusBar(context: Context, window: Window) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    private fun dataInitialize() {

        product1.add(Product(R.drawable.black_jacket))
        product1.add(Product(R.drawable.red_dress))
        product1.add(Product(R.drawable.jean))
        product1.add(Product(R.drawable.gray_tshirt))
        product1.add(Product(R.drawable.lady_shoe))

        product2.add(Product(R.drawable.sleeveless))
        product2.add(Product(R.drawable.red_jacket))
        product2.add(Product(R.drawable.lumber_shirt))
        product2.add(Product(R.drawable.shirt))
        product2.add(Product(R.drawable.casual_shoe))

        reel.add(
            Reel(
                R.drawable.example_reel,
                R.drawable.show_tv,
                "Show TV'nin fenomen dizisi Gelsin Hayat Bildiği Gibi'nin son bölümlerini sitemizden izleyin. #bildiğigibi",
                product1
            )
        )
        reel.add(
            Reel(
                R.drawable.example_reel_2,
                R.drawable.fox_tv,
                "#Baraj'ın dün akşamki final bölümünde Nehir ve Nazım kavuştu! Tekrar izlemek için profildeki linke tıkla.",
                null
            )
        )
        reel.add(
            Reel(
                R.drawable.example_reel_3,
                R.drawable.kanald_logo,
                "Final bölümü etiketimiz #Muhteşemİkili! Bu akşam 19:45’te @KanalD’de!",
                product2
            )
        )
        reel.add(
            Reel(
                R.drawable.example_reel,
                R.drawable.show_tv,
                "Show TV'nin fenomen dizisi Gelsin Hayat Bildiği Gibi'nin son bölümlerini sitemizden izleyin. #bildiğigibi",
                product1
            )
        )
        reel.add(
            Reel(
                R.drawable.example_reel_2,
                R.drawable.fox_tv,
                "#Baraj'ın dün akşamki final bölümünde Nehir ve Nazım kavuştu! Tekrar izlemek için profildeki linke tıkla.",
                null
            )
        )
        reel.add(
            Reel(
                R.drawable.example_reel_3,
                R.drawable.kanald_logo,
                "Final bölümü etiketimiz #Muhteşemİkili! Bu akşam 19:45’te @KanalD’de!",
                product2
            )
        )
        reel.add(
            Reel(
                R.drawable.example_reel,
                R.drawable.show_tv,
                "Show TV'nin fenomen dizisi Gelsin Hayat Bildiği Gibi'nin son bölümlerini sitemizden izleyin. #bildiğigibi",
                product1
            )
        )
        reel.add(
            Reel(
                R.drawable.example_reel_2,
                R.drawable.fox_tv,
                "#Baraj'ın dün akşamki final bölümünde Nehir ve Nazım kavuştu! Tekrar izlemek için profildeki linke tıkla.",
                null
            )
        )
        reel.add(
            Reel(
                R.drawable.example_reel_3,
                R.drawable.kanald_logo,
                "Final bölümü etiketimiz #Muhteşemİkili! Bu akşam 19:45’te @KanalD’de!",
                product2
            )
        )
    }

    /*

    private var y1: Float = 0F
    private var y2: Float = 0F
    private var y3: Float = 0F
    private var MIN_DISTANCE = 250

    private var initialX: Float? = null
    private var initialY: Float? = null

    var lastPos = -1
    rvReel.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
    val pos =
        rvReel.layoutManager!!.getPosition(snapHelper.findSnapView(rvReel.layoutManager)!!)

    if (pos > lastPos) {
        tvTop.visibility = View.GONE
    } else {
        tvTop.visibility = View.VISIBLE
    }
    lastPos = pos
}

ivBanner.setOnTouchListener(object : View.OnTouchListener {
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {

        when (event!!.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                initialX = event.x
                initialY = event.y
            }
            MotionEvent.ACTION_MOVE -> {}
            MotionEvent.ACTION_UP -> {
                val finalX = event.x
                val finalY = event.y


                //Log.d(TAG, "Action was UP");
                if (initialX!! < finalX) {
                    // Log.d(TAG, "Left to Right swipe performed");
                }
                if (initialX!! > finalX) {
                    // Log.d(TAG, "Right to Left swipe performed");
                }

                y2 = event.y
                val deltaY = y2 - y1
                if (abs(deltaY) > MIN_DISTANCE) {
                    //Toast.makeText(applicationContext, "left2right swipe", Toast.LENGTH_SHORT).show()

                    if (initialY!! < finalY) {
                        // Log.d(TAG, "Up to down swipe performed");
                        val pos =
                            rvReel.layoutManager!!.getPosition(
                                snapHelper.findSnapView(
                                    rvReel.layoutManager
                                )!!
                            )
                        rvReel.smoothScrollToPosition(pos - 1)
                    }
                    if (initialY!! > finalY) {
                        // Log.d(TAG, "Down to Up swipe performed");
                        val pos =
                            rvReel.layoutManager!!.getPosition(
                                snapHelper.findSnapView(
                                    rvReel.layoutManager
                                )!!
                            )
                        rvReel.smoothScrollToPosition(pos + 1)
                    }

                } else {
                    // consider as something else - a screen tap for example
                    //v!!.performClick()
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://getir.com/"))
                    startActivity(i)
                }

            }
            MotionEvent.ACTION_CANCEL -> {}
            MotionEvent.ACTION_OUTSIDE -> {}
        }

        return true
    }
})
ItemTouchHelper(object :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.UP or ItemTouchHelper.DOWN) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        // this method is called
        // when the item is moved.
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.UP) {
            //Logic to do when swipe left
            val pos =
                rvReel.layoutManager!!.getPosition(snapHelper.findSnapView(rvReel.layoutManager)!!)
            rvReel.smoothScrollToPosition(pos + 1)

        } else if (direction == ItemTouchHelper.DOWN) {
            //Logic to do when swipe right
            val pos =
                rvReel.layoutManager!!.getPosition(snapHelper.findSnapView(rvReel.layoutManager)!!)
            if (pos != 0) rvReel.smoothScrollToPosition(pos - 1)
        }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
    }

}).attachToRecyclerView(rvProduct)
*/

}