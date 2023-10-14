package com.application.tvizy.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import com.application.tvizy.R
import kotlinx.android.synthetic.main.dialog_change.view.*

class ChangeFragment : DialogFragment() {

    val result = MutableLiveData<String>()
    private var selected = 0

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.9).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val view = inflater.inflate(R.layout.dialog_change, container, false)
        val window: Window? = dialog!!.window
        val wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.CENTER
        dialog!!.setCancelable(true)
        dialog!!.setCanceledOnTouchOutside(true)
        window.attributes = wlp

        view.btnContinue.setOnClickListener {

            if (view.etPassword.text.length < 8) {
                view.etPassword.error = "Şifreniz minimum 8 karakter olmalıdır!"
            } else {
                val confirmFragment = ConfirmFragment()
                confirmFragment.show(childFragmentManager, "confirmFragment")
            }

        }

        view.ivToggle.setOnClickListener {
            if (selected == 0) {
                view.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                selected = 1
                view.ivToggle.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.eye_hide
                    )
                )
            } else {
                view.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                selected = 0
                view.ivToggle.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.eye_show
                    )
                )
            }
        }
        return view
    }
}