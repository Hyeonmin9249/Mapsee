package com.example.mapsee

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mapsee.databinding.ActivityAddClothesBinding

class AddClothesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddClothesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClothesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveClothes.setOnClickListener {
            val clothesName = binding.editTextClothesName.text.toString()
            val brandName = binding.editTextBrandName.text.toString()
            val isOuterwear = binding.checkBoxOuterwear.isChecked
            // Handle other checkboxes similarly

            // Add logic to save these details and update your data source
            // After saving, you may want to finish this activity to return to the previous screen
            finish()
        }
    }
}
