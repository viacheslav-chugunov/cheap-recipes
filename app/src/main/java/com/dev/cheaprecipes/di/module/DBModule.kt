package com.dev.cheaprecipes.di.module

import android.content.Context
import com.dev.data.db.DishesDB
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class DBModule {

    @Provides
    fun provideDishesDB(context: Context) : DishesDB {
        return DishesDB(context)
    }
}