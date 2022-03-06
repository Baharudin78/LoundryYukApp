package com.baharudin.loundryyuk.domain.login.usecase

import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginRequest
import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginResponse
import com.baharudin.loundryyuk.domain.common.BaseResult
import com.baharudin.loundryyuk.domain.login.LoginRepository
import com.baharudin.loundryyuk.domain.login.entity.LoginEntity
import com.baharudin.loundryyuk.util.WrapperResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend fun execute(loginRequest: LoginRequest) : Flow<BaseResult<LoginEntity, WrapperResponse<LoginResponse>>> {
        return loginRepository.login(loginRequest)
    }
}