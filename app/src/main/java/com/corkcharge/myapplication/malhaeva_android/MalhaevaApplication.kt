package com.corkcharge.myapplication.malhaeva_android

import android.app.Application
import com.corkcharge.myapplication.malhaeva_android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MalhaevaApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Koin 초기화
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MalhaevaApplication)
            modules(appModule)
        }
    }
}
