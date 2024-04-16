package com.example.printit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.printit.databinding.ActivityDetailBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class detailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    val TAG = "DETAIL_ACTIVITY"
    private  lateinit var adapter:ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.arrowBack.setOnClickListener {
            val intent = Intent(this@detailActivity, DashboardActivity::class.java)
            startActivity(intent)
        }

        val productList= mutableListOf<Product>()
        val recyclerView: RecyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Set GridLayoutManager with 2 columns
        adapter = ProductAdapter(this,productList)
        recyclerView.adapter = adapter

        val Category:String?=intent.getStringExtra("Category")

        Firebase.firestore.collection("products") .whereEqualTo("category", Category).get()
            .addOnSuccessListener {
                productList.clear()

                for (i in it.documents) {

                    val temproduct = i.toObject<Product>()
                    temproduct?.uniqueid=i.id
                    productList.add(temproduct!!)


                }


               adapter.notifyDataSetChanged()
            }

            .addOnFailureListener {
                Toast.makeText(this@detailActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }

    }


}