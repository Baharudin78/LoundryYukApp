package com.baharudin.loundryyuk.domain.cabang.usecase

import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CabangResponse
import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CreateCabangRequest
import com.baharudin.loundryyuk.domain.cabang.CabangRepository
import com.baharudin.loundryyuk.domain.cabang.entities.CabangEntity
import com.baharudin.loundryyuk.domain.common.BaseResult
import com.baharudin.loundryyuk.util.WrapperResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateCabangUseCase @Inject constructor(
    private val cabangRepository: CabangRepository
) {
    suspend fun invoke(createCabangRequest: CreateCabangRequest) : Flow<BaseResult<CabangEntity, WrapperResponse<CabangResponse>>> {
        return cabangRepository.createCabang(createCabangRequest)
    }
}