package com.dev.cheaprecipes.app.di.module

import android.content.Context
import com.dev.cheaprecipes.data.service.DishService
import com.dev.cheaprecipes.data.repository.DishRepository
import com.dev.cheaprecipes.data.repository.FavouritesDishRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class RepositoryModule {

    @Provides
    fun provideDishRepository(service: DishService): DishRepository =
        DishRepository(service)

    @Provides
    fun provideFavouritesDishRepository(context: Context) =
        FavouritesDishRepository(context)
}