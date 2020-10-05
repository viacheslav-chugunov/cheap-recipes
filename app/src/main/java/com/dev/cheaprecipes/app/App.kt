package com.dev.cheaprecipes.app

import android.app.Application
import com.dev.cheaprecipes.app.di.component.AppComponent
import com.dev.cheaprecipes.app.di.component.DaggerAppComponent
import com.dev.cheaprecipes.app.di.module.AppModule
import com.google.android.gms.ads.MobileAds

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}