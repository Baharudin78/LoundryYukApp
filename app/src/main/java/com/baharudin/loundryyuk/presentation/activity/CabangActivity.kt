package com.baharudin.loundryyuk.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharudin.loundryyuk.databinding.ActivityCabangBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CabangActivity : AppCompatActivity() {

    private lateinit var binding :ActivityCabangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCabangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTambahCabang.setOnClickListener {
            val intentHome = Intent(this, HomeActivity::class.java)
            startActivity(intentHome)
        }
    }
}