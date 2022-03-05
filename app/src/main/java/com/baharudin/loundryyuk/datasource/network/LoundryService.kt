package com.baharudin.loundryyuk.datasource.network

import com.baharudin.loundryyuk.datasource.SimpleResponse
import com.baharudin.loundryyuk.datasource.model.User
import retrofit2.http.Body
import retrofit2.http.POST

interface LoundryService {

    @POST("auth/login")
    suspend fun loginOwner(
        @Body user : User
    ) : SimpleResponse
}