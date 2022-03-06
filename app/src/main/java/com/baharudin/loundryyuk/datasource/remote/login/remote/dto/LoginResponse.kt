package com.baharudin.loundryyuk.datasource.remote.login.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id_user")
    val idUser : String? = null,
    @SerializedName("id_cabang")
    val idCabang : String? = null,
    @SerializedName("username")
    val userName : String? = null,
    @SerializedName("role")
    val role : String? = null,
    @SerializedName("token")
    val token : String? = null
)
