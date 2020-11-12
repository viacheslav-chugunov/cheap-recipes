package com.dev.recipes.app.di.module

import android.content.Context
import com.dev.recipes.data.room.DishDb
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module @DisableInstallInCheck
class RoomModule {

    @Provides
    fun provideDishDb(context: Context) : DishDb =
        DishDb.get(context)
}