package com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto

import com.google.gson.annotations.SerializedName

data class UpdateCabangRequest(
    @SerializedName("cabang")
    val cabang: String,
    @SerializedName("price")
    val price: Int
)