package com.example.mapsee

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mapsee.databinding.ActivityAddClothesBinding

class AddClothesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddClothesBinding
    private var imageBitmap: Bitmap? = null

    companion object {
        val clothesList = mutableListOf<ClothingItem>() // List to store ClothingItem objects
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
            if (clothesName.isNotBlank() && imageBitmap != null) {
                clothesList.add(ClothingItem(imageBitmap!!, clothesName)) // Add ClothingItem to the list
                Toast.makeText(this, "Clothes saved!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please enter a name and take a photo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureLauncher.launch(cameraIntent)
    }
}
