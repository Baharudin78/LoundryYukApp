package com.baharudin.loundryyuk.datasource.implementation

import com.baharudin.loundryyuk.datasource.abstraction.LoundryRepository
import com.baharudin.loundryyuk.datasource.model.User
import com.baharudin.loundryyuk.datasource.network.LoundryService
import com.baharudin.loundryyuk.util.SessionManager
import com.baharudin.loundryyuk.util.isNetworkIsConnected
import com.baharudin.loundryyuk.util.Result
import javax.inject.Inject


class LoundryRepoImpl @Inject constructor(
    val loundryService: LoundryService,
    val sessionManager: SessionManager
) : LoundryRepository {
    override suspend fun loginUser(user: User): Result<String> {
        return try {
            if(!isNetworkIsConnected(sessionManager.context)){
                Result.Error<String>("No Internet Connection!")
            }
            val result = loundryService.loginOwner(user)
            if(result.succes){
                sessionManager.updateSession(result.messege,user.username!!)
                Result.Success("Logged In Successfully!")
            } else {
                Result.Error<String>(result.messege)
            }
        }catch (e:Exception) {
            e.printStackTrace()
            Result.Error(e.message ?: "Some Problem Occurred!")
        }
    }
}