package com.dev.cheaprecipes

import android.app.Application
import com.dev.cheaprecipes.di.component.AppComponent
import com.dev.cheaprecipes.di.component.DaggerAppComponent
import com.dev.cheaprecipes.di.module.AppModule

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