package com.baharudin.loundryyuk.di

import android.content.Context
import com.baharudin.loundryyuk.datasource.abstraction.LoundryRepository
import com.baharudin.loundryyuk.datasource.implementation.LoundryRepoImpl
import com.baharudin.loundryyuk.datasource.network.LoundryService
import com.baharudin.loundryyuk.util.Constant.BASE_URL
import com.baharudin.loundryyuk.util.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSessionManager(
        @ApplicationContext context : Context
    ) = SessionManager(context)

    @Singleton
    @Provides
    fun provideLoundryApi() : LoundryService {
        val httpLoging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoundryService::class.java)
    }

    @Singleton
    @Provides
    fun provideLoundryRepo(
        loundryService: LoundryService,
        sessionManager: SessionManager
    ) : LoundryRepository {
        return LoundryRepoImpl(
            loundryService,
            sessionManager
        )
    }
}