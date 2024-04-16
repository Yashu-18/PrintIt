package com.example.printit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.printit.databinding.ActivitySingleProductBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import java.util.UUID

class singleProductActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySingleProductBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // taking to payment
        binding.buyNow.setOnClickListener {
            startActivity(Intent(this@singleProductActivity,PaymentActivity::class.java).putExtra("amt",binding.currentPriceText.text))
        }
        var productModel=Product()
        var productModelWish= Product()
        var productModelCart=Product()
        var productId=intent.getStringExtra("product_id")
        var productIdWish=intent.getStringExtra("productID")?.trim()
        var productIdCart=intent.getStringExtra("ID")?.trim()


        if(productId!=null) {
            Firebase.firestore.collection("products").document(productId!!).get()
                .addOnSuccessListener {

                    productModel = it.toObject<Product>()!!
                    productModel.uniqueid = productId
                    binding.singleImage.load(productModel.imageurl)
                    binding.des.text = productModel.desc
                    binding.discountPercentText.text = productModel.discount.toString() + "%off"
                    binding.originalPriceText.text = productModel.price.toString()

                    val currentPrice = ((100 - productModel.discount) / 100.00) * productModel.price
                    binding.currentPriceText.text = currentPrice.toString()

                    //adding item to wishlist
                    binding.wish.setOnClickListener {
                        // Check if productModel is not null
                        if (productModel != null) {

                            // Query the wishlist collection to check if the product already exists
                            Firebase.firestore.collection("wishList")
                                .whereEqualTo("imageurl", productModel!!.imageurl)
                                .whereEqualTo("category", productModel!!.category)
                                .whereEqualTo("price", productModel!!.price)
                                .get()
                                .addOnSuccessListener { querySnapshot ->
                                    if (!querySnapshot.isEmpty) {
                                        // Product already exists in the wishlist
                                        Toast.makeText(
                                            this@singleProductActivity,
                                            "Product already in wishlist",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        // Product does not exist in the wishlist, add it
                                        Firebase.firestore.collection("wishList")
                                            .document(UUID.randomUUID().toString())
                                            .set(productModel)
                                            .addOnCompleteListener { task ->
                                                if (task.isSuccessful) {
                                                    Toast.makeText(
                                                        this@singleProductActivity,
                                                        "Product Added!!",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                } else {
                                                    Toast.makeText(
                                                        this@singleProductActivity,
                                                        "Error",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }
                                            }
                                    }
                                }
                                .addOnFailureListener { exception ->
                                    // Handle failure
                                    Toast.makeText(
                                        this@singleProductActivity,
                                        "Error: ${exception.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                        } else {
                            // Handle the case where productModel is null
                            Log.e("singleProductActivity", "ProductModel is null")
                        }
                    }

                    binding.addCart.setOnClickListener {
                        if (productModel != null) {

                            // Query the wishlist collection to check if the product already exists
                            Firebase.firestore.collection("Cart")
                                .whereEqualTo("imageurl", productModel!!.imageurl)
                                .whereEqualTo("category", productModel!!.category)
                                .whereEqualTo("price", productModel!!.price)
                                .get()
                                .addOnSuccessListener { querySnapshot ->
                                    if (!querySnapshot.isEmpty) {
                                        // Product already exists in the wishlist
                                        Toast.makeText(
                                            this@singleProductActivity,
                                            "Product already in Cart",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        // Product does not exist in the wishlist, add it
                                        Firebase.firestore.collection("Cart")
                                            .document(UUID.randomUUID().toString())
                                            .set(productModel)
                                            .addOnCompleteListener { task ->
                                                if (task.isSuccessful) {
                                                    Toast.makeText(
                                                        this@singleProductActivity,
                                                        "Product Added!!",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                } else {
                                                    Toast.makeText(
                                                        this@singleProductActivity,
                                                        "Error",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }
                                            }
                                    }
                                }
                                .addOnFailureListener { exception ->
                                    // Handle failure
                                    Toast.makeText(
                                        this@singleProductActivity,
                                        "Error: ${exception.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                        } else {
                            // Handle the case where productModel is null
                            Log.e("singleProductActivity", "ProductModel is null")
                        }
                    }


                }
        }
        binding.share.setOnClickListener {
            shareProduct(productModel,productModelWish,productModelCart)
        }



        //showing data of wishList
        Log.e("ID","$productIdWish")
        if (productIdWish != null) {
            Firebase.firestore.collection("wishList").whereEqualTo("uniqueid", productIdWish).get()
                .addOnSuccessListener { querySnapshot ->
                    // Iterate through the documents in the snapshot
                    for (document in querySnapshot.documents) {
                        productModelWish = document.toObject<Product>()!!

                            productModelWish.uniqueid = productIdWish
                            binding.singleImage.load(productModelWish.imageurl)
                            binding.des.text = productModelWish.desc
                            binding.discountPercentText.text =
                                productModelWish.discount.toString() + "%off"
                            binding.originalPriceText.text = productModelWish.price.toString()

                            val currentPrice =
                                ((100 - productModelWish.discount) / 100.00) * productModelWish.price
                            binding.currentPriceText.text = currentPrice.toString()

                    }
                }
                .addOnFailureListener { exception ->
                    // Handle failure
                    Log.e("TAG", "Failed to fetch documents: ${exception.message}")
                }
        }

        //showing data of Cart
        if (productIdCart != null) {
            Firebase.firestore.collection("Cart").whereEqualTo("uniqueid", productIdCart).get()
                .addOnSuccessListener { querySnapshot ->
                    // Iterate through the documents in the snapshot
                    for (document in querySnapshot.documents) {
                        productModelCart = document.toObject<Product>()!!

                        productModelCart.uniqueid = productIdWish
                        binding.singleImage.load(productModelCart.imageurl)
                        binding.des.text = productModelCart.desc
                        binding.discountPercentText.text =
                            productModelCart.discount.toString() + "%off"
                        binding.originalPriceText.text = productModelCart.price.toString()

                        val currentPrice =
                            ((100 - productModelCart.discount) / 100.00) * productModelCart.price
                        binding.currentPriceText.text = currentPrice.toString()

                    }
                }
                .addOnFailureListener { exception ->
                    // Handle failure
                    Log.e("TAG", "Failed to fetch documents: ${exception.message}")
                }
        }



    }
    private fun shareProduct(productModel: Product?, productModelWish: Product?, productModelCart: Product?) {
        var productImageURL = ""

        when {
            productModel != null -> {
                productImageURL = productModel.imageurl
            }
            productModelWish != null -> {
                productImageURL = productModelWish.imageurl
            }
            productModelCart != null -> {
                productImageURL = productModelCart.imageurl
            }

        }

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Check out this product!")
            putExtra(Intent.EXTRA_TEXT, productImageURL)
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }





}