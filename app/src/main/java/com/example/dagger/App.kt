package com.example.dagger

import android.app.Application
import com.example.dagger.di.AppModule
import com.example.dagger.di.ApplicationComponent
import com.example.dagger.di.DaggerApplicationComponent
import com.example.dagger.di.NetworkModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        applicationComponent =
            DaggerApplicationComponent.builder()
                .networkModule(NetworkModule())
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        var applicationComponent: ApplicationComponent? = null
    }

}