package com.baharudin.loundryyuk.datasource.remote.cabang.remote.api

import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CabangResponse
import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CreateCabangRequest
import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.UpdateCabangRequest
import com.baharudin.loundryyuk.util.WrapperListResponse
import com.baharudin.loundryyuk.util.WrapperResponse
import retrofit2.Response
import retrofit2.http.*

interface CabangApi {
    @POST("transaction/input-cabang")
    suspend fun createCabang(
        @Body createCabangRequest: CreateCabangRequest
    ) : Response<WrapperResponse<CabangResponse>>

    @GET("transaction/get-cabang")
    suspend fun getAllCabang() : Response<WrapperListResponse<CabangResponse>>

    @POST("transaction/edit-cabang")
    suspend fun updateCabang(
        @Body cabangRequest: UpdateCabangRequest,
        @Path("id") id : String
    ) : Response<WrapperResponse<CabangResponse>>

}