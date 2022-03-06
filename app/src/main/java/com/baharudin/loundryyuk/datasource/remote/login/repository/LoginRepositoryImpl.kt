package com.baharudin.loundryyuk.datasource.remote.login.repository

import com.baharudin.loundryyuk.datasource.remote.login.remote.api.LoginService
import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginRequest
import com.baharudin.loundryyuk.datasource.remote.login.remote.dto.LoginResponse
import com.baharudin.loundryyuk.domain.common.BaseResult
import com.baharudin.loundryyuk.domain.login.LoginRepository
import com.baharudin.loundryyuk.domain.login.entity.LoginEntity
import com.baharudin.loundryyuk.util.WrapperResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginService: LoginService
) : LoginRepository{
    override suspend fun login(loginRequest: LoginRequest): Flow<BaseResult<LoginEntity, WrapperResponse<LoginResponse>>> {
        return flow {
            val response = loginService.loginOwner(loginRequest)
            if (response.isSuccessful) {
                val body = response.body()!!
                val loginEntity = LoginEntity(
                    body.data?.idUser!!,
                    body.data?.idCabang!!,
                    body.data?.userName!!,
                    body.data?.role!!,
                    body.data?.token!!
                )
                emit(BaseResult.Success(loginEntity))
            }else {
                val type = object : TypeToken<WrapperResponse<LoginResponse>>(){}.type
                val error : WrapperResponse<LoginResponse> = Gson().fromJson(response.errorBody()!!.charStream(), type)
                error.statusCode = response.code()
                emit(BaseResult.Error(error))
            }
        }
    }
}