package com.dev.recipes.app.di.module

import com.dev.recipes.data.repository.AllDishRepository
import com.dev.recipes.data.repository.FavouritesDishRepository
import com.dev.recipes.data.retrofit.DishApi
import com.dev.recipes.data.room.DishDb
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module @DisableInstallInCheck
class RepositoryModule {

    @Provides
    fun provideAllDishRepository(api: DishApi) : AllDishRepository =
        AllDishRepository(api)

    @Provides
    fun provideFavouritesDishRepository(dishDb: DishDb) : FavouritesDishRepository =
        FavouritesDishRepository(dishDb.dao())

}