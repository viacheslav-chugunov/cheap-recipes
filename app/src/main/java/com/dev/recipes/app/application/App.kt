package com.dev.recipes.app.application

import android.app.Application
import com.dev.recipes.app.di.component.AppComponent
import com.dev.recipes.app.di.component.DaggerAppComponent
import com.dev.recipes.app.di.module.AppModule

class App : Application() {

    companion object {
        lateinit var dagger: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        dagger = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}