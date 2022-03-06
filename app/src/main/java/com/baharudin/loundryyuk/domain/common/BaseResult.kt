package com.baharudin.loundryyuk.domain.common

sealed class BaseResult<out T : Any , out U : Any> {
    data class Success <T : Any>(val data : T) : BaseResult<T, Nothing>()
    data class Error <U : Any> (val rwaResponse : U) : BaseResult<Nothing, U>()
}
