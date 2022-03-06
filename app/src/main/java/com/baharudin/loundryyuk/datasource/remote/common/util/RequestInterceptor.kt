package com.baharudin.loundryyuk.datasource.remote.common.util

import com.baharudin.loundryyuk.util.SharedPref
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor constructor(
    private val pref : SharedPref
) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = pref.getToken()
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .build()
        return chain.proceed(newRequest)
    }
}