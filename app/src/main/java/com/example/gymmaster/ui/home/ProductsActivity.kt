package com.example.gymmaster.ui.home


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.example.gymmaster.ui.home.Product
import com.example.gymmaster.ui.home.ProductDetailActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class ProductsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val productList = mutableListOf<Product>()
    private lateinit var adapter: ProductAdapter
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = ProductAdapter(productList) { product ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        loadAllProducts()
    }

    private fun loadAllProducts() {
        db.collection("Gym").document("gym1").collection("Products")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { snapshot ->
                productList.clear()
                for (doc in snapshot.documents) {
                    val product = doc.toObject(Product::class.java)
                    if (product != null) {
                        productList.add(product)
                    }
                }
                adapter.notifyDataSetChanged()
            }
    }
}
