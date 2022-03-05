package com.baharudin.loundryyuk.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.baharudin.loundryyuk.databinding.ActivityLoginBinding
import com.baharudin.loundryyuk.ui.viewmodel.UserViewModel
import com.baharudin.loundryyuk.util.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subcribeLogin()

        binding?.loginButton?.setOnClickListener {
            val userName = binding!!.emailEditText.text.toString()
            val password = binding!!.passwordEditText.text.toString()
            userViewModel.loginOwner(
                userName.trim(),
                password.trim()
            )
        }
        binding.tvLupaPassword.setOnClickListener {
            val lupaPw = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(lupaPw)
        }
    }
    private fun subcribeLogin() = lifecycleScope.launch {
        userViewModel.loginState.collect{result ->
            when(result) {
                is Result.Success -> {
                    hideProgressbar()
                    Toast.makeText(this@LoginActivity, "LoginSuccesfully", Toast.LENGTH_SHORT).show()
                    moveToCabang()
                }
                is Result.Error -> {
                    hideProgressbar()
                    Toast.makeText(this@LoginActivity, result.errorMessage, Toast.LENGTH_SHORT).show()
                }
                is  Result.Loading -> {
                    showProgressbar()
                }
            }
        }
    }
    private fun moveToCabang() {
            val intentLogin = Intent(this, CabangActivity::class.java)
            startActivity(intentLogin)
    }
    private fun hideProgressbar() {
        binding.apply {
            progressBar.visibility = View.GONE
        }
    }

    private fun showProgressbar() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
        }
    }
}