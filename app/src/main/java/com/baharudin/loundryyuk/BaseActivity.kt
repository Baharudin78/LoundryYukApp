package com.baharudin.loundryyuk

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class BaseActivity : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}