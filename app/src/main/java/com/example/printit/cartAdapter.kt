package com.example.printit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.printit.databinding.CartItemBinding
import com.example.printit.databinding.WishItemBinding
import java.util.ArrayList

class cartAdapter(var context : Context, var Productlist: ArrayList<Product>): RecyclerView.Adapter<cartAdapter.viewholder>(){

    inner class viewholder(var binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewholder(binding)
    }

    override fun getItemCount(): Int {
       return Productlist.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val imageUrl = Productlist[position].imageurl
        holder.binding.itemImage1.load(imageUrl)
        holder.binding.category.text=Productlist.get(position).category
        holder.binding.paisa.text = Productlist[position].price.toString()
        //holder.binding.qty.text = Productlist[position].qty.toString()
        var amt=((holder.binding.qty.text.toString().toInt())*(Productlist[position].price.toString().toDouble())).toString()
        holder.binding.total.text = amt
        holder.itemView.setOnClickListener{
            val intent = Intent(context, singleProductActivity::class.java)
            intent.putExtra("ID", Productlist.get(position).uniqueid)
            context.startActivity(intent)
        }

    }
}