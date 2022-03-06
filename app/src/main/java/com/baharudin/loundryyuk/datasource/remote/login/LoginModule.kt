package com.baharudin.loundryyuk.datasource.remote.login

import com.baharudin.loundryyuk.datasource.remote.common.module.AppModule
import com.baharudin.loundryyuk.datasource.remote.login.remote.api.LoginService
import com.baharudin.loundryyuk.datasource.remote.login.repository.LoginRepositoryImpl
import com.baharudin.loundryyuk.domain.login.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [AppModule::class])
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Singleton
    @Provides
    fun provideLoginService(retrofit: Retrofit) : LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Singleton
    @Provides
    fun provideLoginRepository(loginService: LoginService) : LoginRepository {
        return LoginRepositoryImpl(loginService)
    }
}