package com.dev.cheaprecipes.di.module

import android.content.Context
import com.dev.data.repository.DishesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class RepositoryModule {

    @Provides
    fun provideDishesRepository(context: Context) : DishesRepository {
        return DishesRepository(context)
    }
}