package com.dev.cheaprecipes.data.repository

import android.content.Context
import com.dev.cheaprecipes.business.model.DishModel
import com.dev.cheaprecipes.data.db.FavouritesDB

class FavouritesDishRepository(private val context: Context) {

    fun getDishes() : List<DishModel> {
        val db = FavouritesDB(context)
        val dishes = db.getDishes()
        db.close()
        return dishes
    }

    fun addDish(id: Int) {
        val db = FavouritesDB(context)
        db.addDish(id)
        db.close()
    }

    fun deleteDish(id: Int) {
        val db = FavouritesDB(context)
        db.deleteDish(id)
        db.close()
    }

    fun isInFavourites(id: Int) : Boolean {
        val db = FavouritesDB(context)
        val isInFavourites = db.containsDish(id)
        db.close()
        return isInFavourites
    }
}