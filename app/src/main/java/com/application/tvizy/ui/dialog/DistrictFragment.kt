package com.application.tvizy.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.tvizy.R
import com.application.tvizy.adapter.DistrictAdapter
import com.application.tvizy.model.District
import kotlinx.android.synthetic.main.dialog_list.view.*

class DistrictFragment : DialogFragment() {

    private var district = ArrayList<District>()
    private val adapter = DistrictAdapter(district)
    val result = MutableLiveData<String>()

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.9).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataInitializer()
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val view = inflater.inflate(R.layout.dialog_list, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp

        view.tvHeadingDialog.text = "Yaşadığınız İlçe"
        view.rvDialog.adapter = adapter
        view.rvDialog.layoutManager = LinearLayoutManager(requireContext())
        adapter.result.observe(viewLifecycleOwner) {
            result.value = it
        }
        return view
    }

    private fun dataInitializer() {
        district.add(District("Esenyurt"))
        district.add(District("Çankaya"))
        district.add(District("Şahinbey"))
        district.add(District("Keçiören"))
        district.add(District("Osmangazi"))
        district.add(District("Şehitkamil"))
        district.add(District("Esenyurt"))
        district.add(District("Çankaya"))
        district.add(District("Şahinbey"))
        district.add(District("Keçiören"))
        district.add(District("Osmangazi"))
        district.add(District("Şehitkamil"))
    }
}