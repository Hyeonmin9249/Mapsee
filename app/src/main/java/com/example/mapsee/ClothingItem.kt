package com.example.mapsee

import android.graphics.Bitmap

data class ClothingItem(
    val image: Bitmap,
    val name: String,
    val brand: String,
    val category: String,
    val thickness: String
)
