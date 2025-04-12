package com.example.gymmaster.ui.home

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.gymmaster.R

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.getSerializableExtra("product") as? Product
        if (product != null) {
            val image: ImageView = findViewById(R.id.productImage)
            val name: TextView = findViewById(R.id.productName)
            val description: TextView = findViewById(R.id.productDescription)
            val quantity: TextView = findViewById(R.id.productQuantity)

            Glide.with(this).load(product.imageUrl).into(image)
            name.text = product.name
            description.text = product.description
            quantity.text = "In stock: ${product.quantity}"
        }
    }
}
