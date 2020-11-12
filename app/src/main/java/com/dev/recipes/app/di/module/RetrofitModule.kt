package com.dev.recipes.app.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module @DisableInstallInCheck
class RetrofitModule {

    @Provides @Singleton
    fun provideGsonConverterFactory() : GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides @Singleton
    fun provideRetrofit(factory: GsonConverterFactory) : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://pastebin.com")
            .addConverterFactory(factory)
            .build()
}