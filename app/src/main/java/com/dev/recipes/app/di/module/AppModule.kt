package com.dev.recipes.app.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module @DisableInstallInCheck
class AppModule(private val app: Application) {

    @Provides @Singleton
    fun provideAppContext() : Context =
        app.applicationContext

}