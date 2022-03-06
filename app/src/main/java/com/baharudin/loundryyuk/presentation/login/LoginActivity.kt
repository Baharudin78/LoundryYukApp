package com.baharudin.loundryyuk.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.baharudin.loundryyuk.R
import com.baharudin.loundryyuk.databinding.ActivityLoginBinding
import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginRequest
import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginResponse
import com.baharudin.loundryyuk.domain.login.entity.LoginEntity
import com.baharudin.loundryyuk.presentation.activity.CabangActivity
import com.baharudin.loundryyuk.presentation.activity.ForgotPasswordActivity
import com.baharudin.loundryyuk.presentation.common.extention.isEmail
import com.baharudin.loundryyuk.presentation.common.extention.showGenericAlertDialog
import com.baharudin.loundryyuk.presentation.common.extention.showToast
import com.baharudin.loundryyuk.util.SharedPref
import com.baharudin.loundryyuk.util.WrapperResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private val viewModel : LoginViewModel by viewModels()
    private val openRegisterActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            goToCabangActivity()
        }
    }
    @Inject
    lateinit var sharedPrefs : SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        login()
        goForgetPassword()
        observe()
    }
    private fun login() {
        binding.loginButton.setOnClickListener {
            val username = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            if (validate(username, password)) {
                val loginRequest = LoginRequest(username, password)
                viewModel.login(loginRequest)
            }
        }
    }
    private fun validate(username : String, password :String) : Boolean {
        resetAllInputError()
        if (!username.isEmail()) {
            setEmailError(getString(R.string.error_email_not_valid))
            return false
        }
        if (password.length < 8) {
            setPasswordError(getString(R.string.error_password_not_valid))
            return false
        }
        return true
    }
    private fun resetAllInputError() {
        setEmailError(null)
        setPasswordError(null)
    }
    private fun setEmailError(e : String?) {
        binding.emailInputLayout.error = e
    }
    private fun setPasswordError(e : String?) {
        binding.passwordInputLayout.error = e
    }
    private fun observe() {
        viewModel.mState
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { state ->
                handleStateChange(state)
            }
            .launchIn(lifecycleScope)
    }
    private fun handleStateChange(state: LoginActivityState) {
        when(state) {
            is LoginActivityState.Init -> Unit
            is LoginActivityState.ErrorLogin -> handleErrorLogin(state.rawResponse)
            is LoginActivityState.SuccessLogin -> handleSuccesLogin(state.loginEntity)
            is LoginActivityState.ShowToast -> showToast(state.message)
            is LoginActivityState.IsLoading -> handleLoading(state.isLoading)
        }
    }
    private fun handleErrorLogin(response : WrapperResponse<LoginResponse>) {
        showGenericAlertDialog(response.message)
    }
    private fun handleLoading(isLoading: Boolean) {
        binding.loginButton.isEnabled = !isLoading
        binding.tvLupaPassword.isEnabled = !isLoading
        binding.progressBar.isIndeterminate = isLoading
        if (!isLoading) {
            binding.progressBar.progress = 0
        }
    }

    private fun handleSuccesLogin(loginEntity: LoginEntity) {
        sharedPrefs.saveToken(loginEntity.token)
        showToast("Welcome ${loginEntity.username}")
        goToCabangActivity()
    }
    private fun goForgetPassword() {
        binding.tvLupaPassword.setOnClickListener {
            openRegisterActivity.launch(Intent(this, ForgotPasswordActivity::class.java))
        }
    }
    private fun goToCabangActivity() {
        startActivity(Intent(this, CabangActivity::class.java))
        finish()
    }
}