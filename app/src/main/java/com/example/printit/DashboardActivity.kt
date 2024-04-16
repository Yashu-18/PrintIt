package com.example.printit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.printit.databinding.ActivityDashboardBinding
import com.example.printit.databinding.FragmentDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    private  val binding by lazy {
        ActivityDashboardBinding.inflate(layoutInflater)
    }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Assuming you have a NavHostFragment with id "nav_host_frame" in your activity_main.xml
        val navHostFragment =supportFragmentManager.findFragmentById(R.id.nav_host_frame) as NavHostFragment
        navController =navHostFragment.navController


        // Assuming you have a BottomNavigationView with id "bottomNavigationView" in your activity_main.xml
        val bottomNavigationView =findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set up BottomNavigationView with the NavController
        bottomNavigationView.setupWithNavController(navController)

    }
}