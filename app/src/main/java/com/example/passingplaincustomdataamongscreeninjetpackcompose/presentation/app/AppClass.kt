package com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.app

import android.app.Application
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppClass : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppClass)
            modules(presentationModule)
        }
    }
}