package com.example.printit


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.printit.databinding.DashboardItemBinding
import java.util.ArrayList


class dashboardAdapter(var context :Context,var Productlist: ArrayList<Pair<String,String>>):RecyclerView.Adapter<dashboardAdapter.viewholder>() {


    inner class viewholder(var binding:DashboardItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val binding = DashboardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewholder(binding)
    }

    override fun getItemCount(): Int {
        return Productlist.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val imageUrl = Productlist[position].first
        holder.binding.itemImage.load(imageUrl) {
            placeholder(R.drawable.place)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(context, singleProductActivity::class.java)
            intent.putExtra("product_id", Productlist.get(position).second)
            context.startActivity(intent)
        }
    }



}