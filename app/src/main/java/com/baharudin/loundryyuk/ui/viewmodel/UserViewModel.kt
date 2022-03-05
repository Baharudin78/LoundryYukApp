package com.baharudin.loundryyuk.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.loundryyuk.datasource.abstraction.LoundryRepository
import com.baharudin.loundryyuk.datasource.model.User
import com.baharudin.loundryyuk.util.Constant.MINIMAL_PASSWORD_VALUE
import com.baharudin.loundryyuk.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    val loundryRepository: LoundryRepository
)  : ViewModel(){

    private val _login = MutableSharedFlow<Result<String>>()
    val loginState : SharedFlow<Result<String>> = _login

    fun loginOwner(
        username : String,
        password : String
    ) = viewModelScope.launch {
        _login.emit(Result.Loading())

        if (username.isEmpty() || password.isEmpty()) {
            _login.emit(Result.Error("Some field is empty"))
            return@launch
        }
        if (!isEmailIsValid(username)) {
            _login.emit(Result.Error("Email is not valid"))
            return@launch
        }
        if (!isPasswordValid(password)) {
            _login.emit(Result.Error("Password should be between $MINIMAL_PASSWORD_VALUE character"))
        }
        val newLogin = User(
            username,
            password
        )
        _login.emit(loundryRepository.loginUser(newLogin))
    }

    private fun isEmailIsValid(username : String) : Boolean {
        val regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
        val pattern = Pattern.compile(regex)
        return (username.isNotEmpty() && pattern.matcher(username).matches())
    }
    private fun isPasswordValid(password: String) : Boolean {
        return (password.length >= MINIMAL_PASSWORD_VALUE)
    }
}