package com.baharudin.loundryyuk.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginRequest
import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginResponse
import com.baharudin.loundryyuk.domain.common.BaseResult
import com.baharudin.loundryyuk.domain.login.entity.LoginEntity
import com.baharudin.loundryyuk.domain.login.usecase.LoginUseCase
import com.baharudin.loundryyuk.util.WrapperResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(){
    private val state = MutableStateFlow<LoginActivityState>(LoginActivityState.Init)
    val mState : StateFlow<LoginActivityState> get() = state

    private fun setLoading() {
        state.value = LoginActivityState.IsLoading(true)
    }
    private fun hideLoading() {
        state.value = LoginActivityState.IsLoading(false)
    }
    private fun showToast(messege : String) {
        state.value = LoginActivityState.ShowToast(messege)
    }
    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            loginUseCase.execute(loginRequest)
                .onStart {
                    setLoading()
                }
                .catch { exception ->
                    hideLoading()
                    showToast(exception.message.toString())
                }
                .collect{ baseResult ->
                    hideLoading()
                    when(baseResult) {
                        is BaseResult.Error -> state.value = LoginActivityState.ErrorLogin(baseResult.rwaResponse)
                        is BaseResult.Success -> state.value = LoginActivityState.SuccessLogin(baseResult.data)
                    }
                }
        }
    }
}

sealed class LoginActivityState {
    object Init : LoginActivityState()
    data class IsLoading(val isLoading: Boolean) : LoginActivityState()
    data class ShowToast(val message: String) : LoginActivityState()
    data class SuccessLogin(val loginEntity: LoginEntity) : LoginActivityState()
    data class ErrorLogin(val rawResponse: WrapperResponse<LoginResponse>) : LoginActivityState()
}