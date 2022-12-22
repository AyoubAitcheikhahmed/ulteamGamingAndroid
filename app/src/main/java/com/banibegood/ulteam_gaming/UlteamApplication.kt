package com.banibegood.ulteam_gaming

import android.app.Application
import timber.log.Timber

class UlteamApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}