package com.dev.cheaprecipes.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class AppModule(private val application: Application) {

    @Provides fun providesApplication() : Application {
        return application
    }

    @Provides fun providesApplicationContext() : Context {
        return application.applicationContext
    }

}