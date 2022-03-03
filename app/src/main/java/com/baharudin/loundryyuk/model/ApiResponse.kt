package com.baharudin.loundryyuk.model

import com.google.gson.annotations.SerializedName

data class ApiResponse<Data> (
    @SerializedName("statusCode")
    val statusCode: Int,
    @SerializedName("message")
    val message : String ,
    @SerializedName("data")
    val data: Data

)
