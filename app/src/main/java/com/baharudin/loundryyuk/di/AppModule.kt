package com.baharudin.loundryyuk.di

import android.content.Context
import com.baharudin.loundryyuk.util.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSessionManager(
        @ApplicationContext context : Context
    ) = SessionManager(context)
}