package com.example.mapsee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ClothesAdapter(private val context: Context, private val clothesList: List<ClothingItem>) : ArrayAdapter<ClothingItem>(context, 0, clothesList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val view = convertView ?: layoutInflater.inflate(R.layout.item_clothing, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.itemImage)
        val textView = view.findViewById<TextView>(R.id.itemName)

        val clothingItem = clothesList[position]
        imageView.setImageBitmap(clothingItem.image)
        textView.text = clothingItem.name

        return view
    }
}
