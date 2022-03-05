package com.baharudin.loundryyuk.datasource.abstraction

import com.baharudin.loundryyuk.datasource.model.User
import com.baharudin.loundryyuk.util.Result

interface LoundryRepository {
    suspend fun loginUser(user : User) : Result<String>
}