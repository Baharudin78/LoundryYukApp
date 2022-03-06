package com.baharudin.loundryyuk.domain.login

import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginRequest
import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginResponse
import com.baharudin.loundryyuk.domain.common.BaseResult
import com.baharudin.loundryyuk.domain.login.entity.LoginEntity
import com.baharudin.loundryyuk.util.WrapperResponse
import kotlinx.coroutines.flow.Flow


interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest) : Flow<BaseResult<LoginEntity, WrapperResponse<LoginResponse>>>
}