package com.baharudin.loundryyuk.datasource.remote.common.module

import com.baharudin.loundryyuk.util.Constant.BASE_URL
import com.baharudin.loundryyuk.datasource.remote.common.util.RequestInterceptor
import com.baharudin.loundryyuk.util.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   @Singleton
   @Provides
   fun provideRetrofit(okHttpClient: OkHttpClient) :Retrofit {
       return Retrofit.Builder().apply {
           addConverterFactory(GsonConverterFactory.create())
           client(okHttpClient)
           baseUrl(BASE_URL)
       }.build()
   }
    @Singleton
    @Provides
    fun provideOkHttp(requestInterceptor : RequestInterceptor) : OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            addInterceptor(requestInterceptor)
        }.build()
    }

    @Provides
    fun privideRequestInterceptor(pref : SharedPref) : RequestInterceptor {
        return RequestInterceptor(pref)
    }

}