package com.dev.cheaprecipes.app.di.module

import com.dev.cheaprecipes.data.service.DishService
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import retrofit2.Retrofit

@Module
@DisableInstallInCheck
class ServiceModule {

    @Provides
    fun provideDishService(retrofit: Retrofit) : DishService =
        retrofit.create(DishService::class.java)
}