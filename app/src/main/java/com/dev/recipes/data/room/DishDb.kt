package com.dev.recipes.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dev.recipes.business.model.Dish

@Database(entities = [Dish::class], version = 1)
abstract class DishDb : RoomDatabase() {

    companion object {

        fun get(c: Context) : DishDb {
            return Room
                .databaseBuilder(c, DishDb::class.java, "dish_database")
                .build()
        }

    }

    abstract fun dao() : DishDao

}