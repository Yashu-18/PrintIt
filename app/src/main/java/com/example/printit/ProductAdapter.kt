package com.example.printit
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.printit.databinding.ItemProductBinding

class ProductAdapter(var context : Context, private val productList:List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        // Load product image with Coil
        holder.binding.productImage.load(productList[position].imageurl) {
            placeholder(R.drawable.place)
        }

        holder.binding.discountPercentText.text = "↓ "+product.discount.toString()+"%"
        holder.binding.originalPriceText.text = product.price.toString()

        val currentPrice=((100-product.discount)/100.00)*product.price

        holder.binding.currentPriceText.text = currentPrice.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(context, singleProductActivity::class.java)
            intent.putExtra("product_id", productList.get(position).uniqueid)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = productList.size


}
