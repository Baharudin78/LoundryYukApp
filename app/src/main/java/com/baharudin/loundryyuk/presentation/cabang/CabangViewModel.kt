package com.baharudin.loundryyuk.presentation.cabang

import androidx.lifecycle.ViewModel
import com.baharudin.loundryyuk.domain.cabang.usecase.CreateCabangUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CabangViewModel @Inject constructor(
    private val createCabangUseCase: CreateCabangUseCase
) : ViewModel(){
    private val state = MutableStateFlow<CreateCabangState>(CreateCabangState.Init)
    val mState : StateFlow<CreateCabangState> get() = state

    private fun setLoading() {
        state.value = CreateCabangState.IsLoading(true)
    }
}
sealed class CreateCabangState{
    object Init : CreateCabangState()
    object SuccessCreate : CreateCabangState()
    data class IsLoading(val isLoading: Boolean) : CreateCabangState()
    data class ShowToast(val messege : String) : CreateCabangState()
}