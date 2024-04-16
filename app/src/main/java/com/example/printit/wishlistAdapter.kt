package com.example.printit

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.printit.databinding.DashboardItemBinding
import com.example.printit.databinding.WishItemBinding
import java.util.ArrayList

class wishlistAdapter(var context : Context, var Productlist: ArrayList<Product>): RecyclerView.Adapter<wishlistAdapter.viewholder>()  {

    inner class viewholder(var binding: WishItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val binding = WishItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewholder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("size","${Productlist.size}")
        return Productlist.size

    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val imageUrl = Productlist[position].imageurl
        holder.binding.itemImage.load(imageUrl)
        holder.binding.category.text=Productlist.get(position).category
        holder.binding.paisa.text = Productlist[position].price.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(context, singleProductActivity::class.java)
            intent.putExtra("productID", Productlist.get(position).uniqueid)
            context.startActivity(intent)
        }

    }


}