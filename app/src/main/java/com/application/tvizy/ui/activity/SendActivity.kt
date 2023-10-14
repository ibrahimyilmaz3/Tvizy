package com.application.tvizy.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.application.tvizy.R
import com.application.tvizy.service.Tools
import com.application.tvizy.util.BaseAppCompatActivity
import com.application.tvizy.util.funIntent
import kotlinx.android.synthetic.main.activity_send.*


class SendActivity : BaseAppCompatActivity() {

    private var selected = 0

    private val pickImage = 100
    private var imageUri: Uri? = null

    private val REQUEST_IMAGE_CAPTURE = 1

    private val CAMERA_PERMISSION_CODE = 1
    private val REQUEST_CODE_PERMISSION_GALLERY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        Tools().whiteStatusBar(this, window)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        linearBack.setOnClickListener {
            finish()
        }

        ivProfile.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                intent.getIntExtra("image", 0)
            )
        )
        tvName.text = intent.getStringExtra("name")

        etSendMessage.addTextChangedListener {

            if (etSendMessage.text.toString().isEmpty()) {
                ivAttach.visibility = View.VISIBLE
                ivSend.visibility = View.GONE
            } else {
                ivAttach.visibility = View.GONE
                ivSend.visibility = View.VISIBLE
                linearAttach.visibility = View.GONE
                selected = 0
            }
        }

        linearProfile.setOnClickListener {
            funIntent(FollowingActivity())
        }

        ivAttach.setOnClickListener {
            if (selected == 0) {
                linearAttach.visibility = View.VISIBLE
                selected = 1
            } else {
                linearAttach.visibility = View.GONE
                selected = 0
            }
        }

        linearGallery.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // Request permission to read external storage
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    REQUEST_CODE_PERMISSION_GALLERY
                )
            } else {
                openGallery()
            }
        }

        linearCamera.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                dispatchTakePictureIntent()
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
            }
        }
    }

    private fun SendActivity.openGallery() {
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, pickImage)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            // Do something with the image
        }
    }

    fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchTakePictureIntent()
            } else {
                // Permission denied, show error message or disable camera functionality
            }
        }
        when (requestCode) {
            REQUEST_CODE_PERMISSION_GALLERY -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted, access the gallery
                    openGallery()
                } else {
                    // Permission is denied, show a message or take appropriate action
                }
            }
        }
    }
}