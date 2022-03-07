package com.baharudin.loundryyuk.domain.cabang.usecase

import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CabangResponse
import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.UpdateCabangRequest
import com.baharudin.loundryyuk.domain.cabang.CabangRepository
import com.baharudin.loundryyuk.domain.cabang.entities.CabangEntity
import com.baharudin.loundryyuk.domain.common.BaseResult
import com.baharudin.loundryyuk.util.WrapperResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateCabangUseCase @Inject constructor(
    private val cabangRepository: CabangRepository
) {
    suspend fun invoke(updateCabangRequest: UpdateCabangRequest, id : String) : Flow<BaseResult<CabangEntity, WrapperResponse<CabangResponse>>> {
        return cabangRepository.updateCabang(updateCabangRequest, id)
    }
}