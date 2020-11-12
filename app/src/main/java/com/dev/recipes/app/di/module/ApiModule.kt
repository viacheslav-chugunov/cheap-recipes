package com.dev.recipes.app.di.module

import com.dev.recipes.data.retrofit.DishApi
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import retrofit2.Retrofit
import javax.inject.Singleton

@Module @DisableInstallInCheck
class ApiModule {

    @Provides @Singleton
    fun provideDishApi(retrofit: Retrofit) : DishApi =
        retrofit.create(DishApi::class.java)
}