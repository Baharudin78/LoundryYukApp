package com.baharudin.loundryyuk.model.network

import com.baharudin.loundryyuk.model.ApiResponse
import com.baharudin.loundryyuk.model.data.Owner
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("auth/login")
    suspend fun loginOwner(
        @Body owner: Owner
    ) : ApiResponse<Owner>
}