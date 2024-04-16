package com.example.printit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.printit.databinding.FragmentCartBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject


class CartFragment : Fragment() {

    private lateinit var binding:FragmentCartBinding
    private lateinit var Adapter1: cartAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productList1 = arrayListOf<Product>()
        Adapter1 = cartAdapter(requireContext(), productList1)
        binding.rvCart.adapter = Adapter1
        binding.rvCart.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        Firebase.firestore.collection("Cart").get().addOnSuccessListener {
            productList1?.clear()
            for (i in it.documents) {
                val temproduct = i.toObject<Product>()
                productList1.add(temproduct!!)



            }
            Adapter1.notifyDataSetChanged()
        }

    }

}