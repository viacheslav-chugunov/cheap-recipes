package com.dev.cheaprecipes.app.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@DisableInstallInCheck
class RetrofitModule {

    @Provides
    fun provideRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl("https://pastebin.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}