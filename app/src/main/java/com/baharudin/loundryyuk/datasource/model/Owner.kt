package com.baharudin.loundryyuk.datasource.model

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("idCabang")
    val idCabang: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("username")
    val username: String
)
