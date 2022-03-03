package com.baharudin.loundryyuk.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baharudin.loundryyuk.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLupaPassword.setOnClickListener {
            val lupaPw = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(lupaPw)
        }
        binding.loginButton.setOnClickListener {
            val intentLogin = Intent(this, CabangActivity::class.java)
            startActivity(intentLogin)
        }
    }
}