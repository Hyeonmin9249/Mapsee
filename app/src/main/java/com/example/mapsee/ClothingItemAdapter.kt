import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mapsee.ClothingItem
import com.example.mapsee.R

class ClothingItemAdapter(context: Context, private val clothingItems: List<ClothingItem>) : ArrayAdapter<ClothingItem>(context, 0, clothingItems) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate the custom layout
        val layoutInflater = LayoutInflater.from(context)
        val view = convertView ?: layoutInflater.inflate(R.layout.item_clothing, parent, false)

        // Get references to the views
        val imageView = view.findViewById<ImageView>(R.id.itemImage)
        val textView = view.findViewById<TextView>(R.id.itemName)

        // Set the data to the views
        val clothingItem = clothingItems[position]
        imageView.setImageBitmap(clothingItem.image)
        textView.text = clothingItem.name

        return view
    }
}
