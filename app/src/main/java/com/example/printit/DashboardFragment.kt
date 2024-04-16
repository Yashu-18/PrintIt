package com.example.printit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.printit.databinding.ActivityForgetpassBinding
import com.example.printit.databinding.FragmentDashboardBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class DashboardFragment : Fragment() {

    private lateinit var binding:FragmentDashboardBinding
    private lateinit var Adapter1: dashboardAdapter
    private lateinit var Adapter2: dashboardAdapter
    private lateinit var Adapter3: dashboardAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDashboardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel(R.drawable.slider,ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.slider,ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.slider,ScaleTypes.CENTER_CROP))
        binding.imageSlider.setImageList(imageList)



        // Create an instance of the adapter and set it to the RecyclerView
        val productList1 = arrayListOf<Pair<String,String>>()
        Adapter1 = dashboardAdapter(requireContext(), productList1)
        binding.rvWedding.adapter = Adapter1
        binding.rvWedding.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        Firebase.firestore.collection("products") .whereEqualTo("category", "Weeding Card").limit(10).get().addOnSuccessListener {
            productList1?.clear()
            for (i in it.documents) {
                val imageUrl = i.getString("imageurl") // Assuming "imageUrl" is the field name for image URLs in your Firestore documents
                if (imageUrl != null) {
                    val uniqueid=i.id
                    val newPair = Pair(imageUrl,uniqueid)
                    productList1.add(newPair)
                }


            }
            Adapter1.notifyDataSetChanged()
        }
            .addOnFailureListener {
                Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        // Create product list for rvPoster

        val productList2 = arrayListOf<Pair<String,String>>()
        Adapter2 = dashboardAdapter(requireContext(), productList2)
        binding.rvPoster.adapter = Adapter2
        binding.rvPoster.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        Firebase.firestore.collection("products") .whereEqualTo("category", "Poster").limit(10).get().addOnSuccessListener {
            productList2?.clear()
            for (i in it.documents) {
                val imageUrl = i.getString("imageurl") // Assuming "imageUrl" is the field name for image URLs in your Firestore documents
                if (imageUrl != null) {
                    val uniqueid=i.id
                    val newPair = Pair(imageUrl,uniqueid)
                    productList2.add(newPair)
                }


            }
            Adapter2.notifyDataSetChanged()
        }
            .addOnFailureListener {
                Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        // Create product list for rvBirthday
        val productList3 = arrayListOf<Pair<String,String>>()
        Adapter3 = dashboardAdapter(requireContext(), productList3)
        binding.rvBirthday.adapter = Adapter3
        binding.rvBirthday.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        Firebase.firestore.collection("products") .whereEqualTo("category", "Birthday Card").limit(10).get().addOnSuccessListener {
            productList3?.clear()
            for (i in it.documents) {
                val imageUrl = i.getString("imageurl") // Assuming "imageUrl" is the field name for image URLs in your Firestore documents
                if (imageUrl != null) {
                    val uniqueid=i.id
                    val newPair = Pair(imageUrl,uniqueid)
                    productList3.add(newPair)

                    val image=it.documents
                }


            }
            Adapter3.notifyDataSetChanged()
        }
            .addOnFailureListener {
                Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        binding.weddingMore.setOnClickListener {
            performAction("Weeding Card")
        }

        binding.catWedd.setOnClickListener {
            performAction("Weeding Card")
        }

        binding.posterMore.setOnClickListener {
            performAction("Poster")
        }
        binding.catPos.setOnClickListener {
            performAction("Poster")
        }
        binding.birthdayMore.setOnClickListener {
            performAction("Birthday Card")
        }

        binding.catBir.setOnClickListener {
            performAction("Birthday Card")
        }
    }
    private fun performAction(cat:String){
        startActivity(Intent(requireContext(),detailActivity::class.java).putExtra("Category",cat))
    }
}