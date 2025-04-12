package com.example.gymmaster.ui.home


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymmaster.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

//class HomeFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }
//}

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val productList = mutableListOf<Product>()
    private lateinit var adapter: ProductAdapter
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        adapter = ProductAdapter(productList) { product ->
            val intent = Intent(requireContext(), ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        loadLatestProducts()

        val showMore = view.findViewById<TextView>(R.id.showMore)
        showMore.setOnClickListener {
            startActivity(Intent(requireContext(), ProductsActivity::class.java))
        }

        return view
    }

    private fun loadLatestProducts() {
        db.collection("Gym").document("gym1").collection("Products")
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .limit(4)
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


