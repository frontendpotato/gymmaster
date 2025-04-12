package com.example.gymmaster

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class GymMasterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
} 