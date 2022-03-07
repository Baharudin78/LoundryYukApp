package com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto

import com.google.gson.annotations.SerializedName

data class CabangResponse(
    @SerializedName("__v")
    val v: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("cabang")
    val cabang: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("createdBy")
    val createdBy: String,
    @SerializedName("price")
    val price: Int
)