package com.baharudin.loundryyuk.util

import com.google.gson.annotations.SerializedName

data class WrapperListResponse<T>(
    @SerializedName("statusCode")
    var statusCode : Int,
    @SerializedName("messege")
    var messege : String,
    @SerializedName("data")
    var data : List<T>? = null
)

data class WrapperResponse<T>(
    @SerializedName("statusCode")
    var statusCode : Int,
    @SerializedName("message")
    var message : String,
    @SerializedName("data")
    var data: T? =  null
)
