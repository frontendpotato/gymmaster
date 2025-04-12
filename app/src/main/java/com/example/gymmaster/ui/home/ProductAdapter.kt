package com.example.gymmaster.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymmaster.R
import com.example.gymmaster.ui.home.Product

class ProductAdapter(
    private val productList: List<Product>,
    private val clickListener: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.productName)
        private val image: ImageView = itemView.findViewById(R.id.productImage)

        fun bind(product: Product) {
            name.text = product.name
            Glide.with(itemView.context).load(product.imageUrl).into(image)

            itemView.setOnClickListener {
                clickListener(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size
}
