package com.example.myapplication.utils

import androidx.multidex.MultiDexApplication
import com.example.myapplication.retrofit.networkRequests
import com.example.myapplication.retrofit.retrofit
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppController :   MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            androidLogger()
            androidContext(this@AppController)
            modules(
                listOf(
                    retrofit,networkRequests, viewModelModule
                )
            )
        }

    }


}