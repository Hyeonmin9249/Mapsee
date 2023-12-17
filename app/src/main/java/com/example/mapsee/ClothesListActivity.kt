package com.example.mapsee

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.mapsee.databinding.ActivityClothesListBinding

class ClothesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClothesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClothesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.titleTextView.text = "My Clothes List"

        // Set up the ListView with the clothes list
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, AddClothesActivity.clothesList)
        binding.listViewClothes.adapter = adapter
    }
}
