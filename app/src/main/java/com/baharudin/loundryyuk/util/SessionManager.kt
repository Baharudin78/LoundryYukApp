package com.baharudin.loundryyuk.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.baharudin.loundryyuk.util.Constant.EMAIL_KEY
import com.baharudin.loundryyuk.util.Constant.JWT_TOKEN_KEY
import com.baharudin.loundryyuk.util.Constant.USER_KEY
import kotlinx.coroutines.flow.first

class SessionManager(val context : Context) {
    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("session_manager")

    suspend fun updateSession(token : String, username : String, email : String) {
        val jwtToken = stringPreferencesKey(JWT_TOKEN_KEY)
        val userKey = stringPreferencesKey(USER_KEY)
        val emailKey = stringPreferencesKey(EMAIL_KEY)
        context.dataStore.edit { preference ->
            preference[jwtToken] = token
            preference[userKey] = username
            preference[emailKey] = email
        }
    }

    suspend fun getJwtToken() :String? {
        val jwtToken = stringPreferencesKey(JWT_TOKEN_KEY)
        val preference = context.dataStore.data.first()
        return preference[jwtToken]
    }

    suspend fun getCurrentUser() : String? {
        val userKey = stringPreferencesKey(USER_KEY)
        val preference = context.dataStore.data.first()
        return preference[userKey]
    }

    suspend fun getCurrentEmail() : String? {
        val emailKey = stringPreferencesKey(EMAIL_KEY)
        val preference = context.dataStore.data.first()
        return preference[emailKey]
    }

    suspend fun logOut() {
        context.dataStore.edit {
            it.clear()
        }
    }

 }