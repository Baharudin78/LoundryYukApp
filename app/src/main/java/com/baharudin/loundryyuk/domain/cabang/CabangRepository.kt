package com.baharudin.loundryyuk.domain.cabang

import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CabangResponse
import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CreateCabangRequest
import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.UpdateCabangRequest
import com.baharudin.loundryyuk.domain.cabang.entities.CabangEntity
import com.baharudin.loundryyuk.domain.common.BaseResult
import com.baharudin.loundryyuk.util.WrapperListResponse
import com.baharudin.loundryyuk.util.WrapperResponse
import kotlinx.coroutines.flow.Flow

interface CabangRepository {
    suspend fun getAllCabang(): Flow<BaseResult<List<CabangEntity>, WrapperListResponse<CabangResponse>>>
    suspend fun createCabang(createCabangRequest: CreateCabangRequest) : Flow<BaseResult<CabangEntity, WrapperResponse<CabangResponse>>>
    suspend fun updateCabang(updateCabangRequest: UpdateCabangRequest, id : String) : Flow<BaseResult<CabangEntity, WrapperResponse<CabangResponse>>>
}