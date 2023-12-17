package com.example.mapsee

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mapsee.databinding.ActivityClothesListBinding

class ClothesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClothesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClothesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.titleTextView.text = "My Clothes List"
    }
}
