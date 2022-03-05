package com.baharudin.loundryyuk.datasource.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("password")
    val password: String? = null,
)
