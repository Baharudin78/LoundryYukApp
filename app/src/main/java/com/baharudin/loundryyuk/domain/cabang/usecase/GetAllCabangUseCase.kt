package com.baharudin.loundryyuk.domain.cabang.usecase

import com.baharudin.loundryyuk.datasource.remote.cabang.remote.dto.CabangResponse
import com.baharudin.loundryyuk.domain.cabang.CabangRepository
import com.baharudin.loundryyuk.domain.cabang.entities.CabangEntity
import com.baharudin.loundryyuk.domain.common.BaseResult
import com.baharudin.loundryyuk.util.WrapperListResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCabangUseCase @Inject constructor(
    private val cabangRepository: CabangRepository
) {
    suspend fun invoke() : Flow<BaseResult<List<CabangEntity>, WrapperListResponse<CabangResponse>>> {
        return cabangRepository.getAllCabang()
    }
}