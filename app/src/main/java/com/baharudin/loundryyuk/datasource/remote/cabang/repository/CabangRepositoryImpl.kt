package com.baharudin.loundryyuk.datasource.remote.cabang.repository

import com.baharudin.loundryyuk.datasource.remote.cabang.remote.api.CabangApi
import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CabangResponse
import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CreateCabangRequest
import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.UpdateCabangRequest
import com.baharudin.loundryyuk.domain.cabang.CabangRepository
import com.baharudin.loundryyuk.domain.cabang.entities.CabangEntity
import com.baharudin.loundryyuk.domain.common.BaseResult
import com.baharudin.loundryyuk.util.WrapperListResponse
import com.baharudin.loundryyuk.util.WrapperResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CabangRepositoryImpl @Inject constructor(
    private val cabangApi: CabangApi
) : CabangRepository {
    override suspend fun getAllCabang(): Flow<BaseResult<List<CabangEntity>, WrapperListResponse<CabangResponse>>> {
        return flow {
            val response = cabangApi.getAllCabang()
            if (response.isSuccessful) {
                val body = response.body()!!
                val cabang = mutableListOf<CabangEntity>()
                body.data?.forEach { cabangResponse ->
                    cabang.add(
                        CabangEntity(
                        cabangResponse.v,
                        cabangResponse.id,
                        cabangResponse.cabang,
                        cabangResponse.createdAt,
                        cabangResponse.createdBy,
                        cabangResponse.price
                    )
                    )
                }
                emit(BaseResult.Success(cabang))
            }else {
                val type = object : TypeToken<WrapperListResponse<CabangResponse>>(){}.type
                val error = Gson().fromJson<WrapperListResponse<CabangResponse>>(response.errorBody()!!.charStream(), type)!!
                error.statusCode = response.code()
                emit(BaseResult.Error(error))
            }
        }
    }

    override suspend fun createCabang(createCabangRequest: CreateCabangRequest): Flow<BaseResult<CabangEntity, WrapperResponse<CabangResponse>>> {
        return flow {
            val response = cabangApi.createCabang(createCabangRequest)
            if (response.isSuccessful) {
                val body = response.body()!!
                val cabang = CabangEntity(
                    body.data?.v!!,
                    body.data?.id!!,
                    body.data?.cabang!!,
                    body.data?.createdAt!!,
                    body.data?.createdBy!!,
                    body.data?.price!!
                )
                emit(BaseResult.Success(cabang))
            }else {
                val type = object : TypeToken<WrapperResponse<CabangResponse>>(){}.type
                val error = Gson().fromJson<WrapperResponse<CabangResponse>>(response.errorBody()!!.charStream(),type)!!
                error.statusCode = response.code()
                emit(BaseResult.Error(error))
            }
        }
    }

    override suspend fun updateCabang(
        updateCabangRequest: UpdateCabangRequest,
        id: String
    ): Flow<BaseResult<CabangEntity, WrapperResponse<CabangResponse>>> {
        return flow {
            val response = cabangApi.updateCabang(updateCabangRequest, id)
            if (response.isSuccessful) {
                val body = response.body()!!
                val cabang = CabangEntity(
                    body.data?.v!!,
                    body.data?.id!!,
                    body.data?.cabang!!,
                    body.data?.createdAt!!,
                    body.data?.createdBy!!,
                    body.data?.price!!
                )
                emit(BaseResult.Success(cabang))
            }else {
                val type = object : TypeToken<WrapperResponse<CabangResponse>>(){}.type
                val error = Gson().fromJson<WrapperResponse<CabangResponse>>(response.errorBody()!!.charStream(),type)!!
                error.statusCode = response.code()
                emit(BaseResult.Error(error))
            }
        }
    }
}