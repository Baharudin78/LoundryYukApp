package com.baharudin.loundryyuk.domain.login.entity

data class LoginEntity(
    var id_user : String,
    var id_cabang : String,
    var username : String,
    var role : String,
    var token : String
)
