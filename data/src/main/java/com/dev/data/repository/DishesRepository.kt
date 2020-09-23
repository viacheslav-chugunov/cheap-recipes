package com.dev.data.repository

import android.content.Context
import com.dev.data.db.DishesDB
import java.lang.IllegalArgumentException

class DishesRepository(private val context: Context) {

    class CardDish(val id: Int, val name: String, val imgId: Int)
    class FullDish(val id: Int, val name: String, val imgId: Int, val ingredients: String,
                   val preparation: String, val inFavourites: Boolean)

    fun getCardDish(id: Int) : CardDish {
        getCardDishes().forEach {
            if (it.id == id)
                return it
        }
        throw IllegalArgumentException("DB does not contain dish with id $id")
    }

    fun getCardDishes() : List<CardDish> {
        val cardDishes = mutableListOf<CardDish>()
        val db = DishesDB(context)
        getAllNames().forEach { name ->
            val id = db.getIdBy(name)
            val imgId = db.getImgIdBy(name)
            cardDishes.add(CardDish(id, name, imgId))
        }
        db.close()
        return cardDishes
    }

    fun getFavouritesCardDishes() : List<CardDish> {
        val favouritesCardDishes = mutableListOf<CardDish>()
        val db = DishesDB(context)
        getAllNames().forEach { name ->
            if (db.isInFavouritesBy(name)) {
                val id = db.getIdBy(name)
                val imgId = db.getImgIdBy(name)
                favouritesCardDishes.add(CardDish(id, name, imgId))
            }
        }
        db.close()
        return favouritesCardDishes
    }

    fun getFullDish(id: Int) : FullDish {
        getFullDishes().forEach {
            if (it.id == id)
                return it
        }
        throw IllegalArgumentException("DB does not contain dish with id $id")
    }

    fun getFullDishes() : List<FullDish> {
        val fullDishes = mutableListOf<FullDish>()
        val db = DishesDB(context)
        getAllNames().forEach { name ->
            val id = db.getIdBy(name)
            val imgId = db.getImgIdBy(name)
            val ingredients = db.getIngredientsBy(name)
            val preparation = db.getPreparationBy(name)
            val inFavourites = db.isInFavouritesBy(name)
            fullDishes.add(FullDish(id, name, imgId, ingredients, preparation, inFavourites))
        }
        db.close()
        return fullDishes
    }

    private fun getAllNames() : List<String> {
        val db = DishesDB(context)
        val allNames = db.getAllNames()
        db.close()
        return allNames
    }

    fun isInFavouritesBy(name: String) : Boolean {
        val db = DishesDB(context)
        val isInFavourites =  db.isInFavouritesBy(name)
        db.close()
        return isInFavourites
    }


    fun updateFavouritesBy(id: Int) {
        val db = DishesDB(context)
        db.updateFavourites(id)
        db.close()
    }
}