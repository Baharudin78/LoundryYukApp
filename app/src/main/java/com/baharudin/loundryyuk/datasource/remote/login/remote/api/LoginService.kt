package com.baharudin.loundryyuk.datasource.remote.login.remote.api

import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginRequest
import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginResponse
import com.baharudin.loundryyuk.util.WrapperResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("auth/login")
    suspend fun loginOwner(
        @Body loginRequest : LoginRequest
    ) : Response<WrapperResponse<LoginResponse>>
}