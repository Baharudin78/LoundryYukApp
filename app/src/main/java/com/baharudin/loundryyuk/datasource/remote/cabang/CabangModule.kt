package com.baharudin.loundryyuk.datasource.remote.cabang

import com.baharudin.loundryyuk.datasource.remote.cabang.remote.api.CabangApi
import com.baharudin.loundryyuk.datasource.remote.cabang.repository.CabangRepositoryImpl
import com.baharudin.loundryyuk.datasource.remote.common.module.AppModule
import com.baharudin.loundryyuk.domain.cabang.CabangRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [AppModule::class])
@InstallIn(SingletonComponent::class)
class CabangModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) : CabangApi {
        return retrofit.create(CabangApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCabangRepository(cabangApi: CabangApi) : CabangRepository {
        return CabangRepositoryImpl(cabangApi)
    }
}