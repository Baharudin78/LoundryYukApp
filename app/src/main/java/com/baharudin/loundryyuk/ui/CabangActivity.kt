package com.baharudin.loundryyuk.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharudin.loundryyuk.R
import com.baharudin.loundryyuk.databinding.ActivityCabangBinding

class CabangActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCabangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCabangBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}