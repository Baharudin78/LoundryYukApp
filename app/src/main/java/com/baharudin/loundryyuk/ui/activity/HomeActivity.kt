package com.baharudin.loundryyuk.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.baharudin.loundryyuk.R
import com.baharudin.loundryyuk.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var navigation = supportFragmentManager.findFragmentById(R.id.fragment_view) as NavHostFragment
        navigation.findNavController()
        navController = navigation.findNavController()
        binding.bottomNav.setupWithNavController(navController)
    }
}