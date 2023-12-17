package com.example.mapsee

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.mapsee.databinding.ActivityAddClothesBinding

class AddClothesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddClothesBinding
    private var imageBitmap: Bitmap? = null

    companion object {
        val clothesList = mutableListOf<String>() // Static list to store clothes names
    }

    private val requestCameraPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            openCamera()
        } else {
            Toast.makeText(this, "Camera permission is required to take photos", Toast.LENGTH_SHORT).show()
        }
    }

    private val takePictureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == AppCompatActivity.RESULT_OK && result.data != null) {
            imageBitmap = result.data?.extras?.get("data") as Bitmap
            binding.imageViewClothes.setImageBitmap(imageBitmap)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClothesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUploadPicture.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }

        binding.btnSaveClothes.setOnClickListener {
            val clothesName = binding.editTextClothesName.text.toString()
            if (clothesName.isNotBlank()) {
                clothesList.add(clothesName) // Add the clothes name to the list
                Toast.makeText(this, "Clothes saved!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please enter a clothes name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureLauncher.launch(cameraIntent)
    }
}
