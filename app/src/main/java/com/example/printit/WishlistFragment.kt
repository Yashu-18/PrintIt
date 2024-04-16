package com.example.printit

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.printit.databinding.FragmentWishlistBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject


class WishlistFragment : Fragment() {

    private lateinit var binding: FragmentWishlistBinding
    private lateinit var adapter: wishlistAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var productList3= ArrayList<Product>()
        adapter= wishlistAdapter(requireContext(), productList3)
        binding.rvWishlist.adapter = adapter
        binding.rvWishlist.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        Firebase.firestore.collection("wishList").get().addOnSuccessListener {
            productList3?.clear()
            for (i in it.documents) {
                val temproduct = i.toObject<Product>()
                productList3.add(temproduct!!)



            }
            adapter.notifyDataSetChanged()
        }
        binding.arrow.setOnClickListener {
            startActivity(Intent(requireContext(),DashboardActivity::class.java))
        }



    }
}
