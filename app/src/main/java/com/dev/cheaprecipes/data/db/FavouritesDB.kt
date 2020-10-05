package com.dev.cheaprecipes.data.db

import android.content.ContentValues
import android.content.Context
import com.dev.cheaprecipes.business.model.DishModel
import com.dev.cheaprecipes.data.db.FavouritesDBHelper.Companion.TABLE

class FavouritesDB(context: Context) {
    private val db = FavouritesDBHelper(context).writableDatabase

    companion object {
        const val KEY_ID = "id"
        const val KEY_NAME = "name"
        const val KEY_IMG_URL = "img_url"
        const val KEY_INGREDIENTS = "ingredients"
        const val KEY_PREPARATION = "preparation"
    }

    fun close() = db.close()

    fun getDishes() : List<DishModel> {
        val dishes = mutableListOf<DishModel>()
        val cursor = getQuery()
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
                val imgURL = cursor.getString(cursor.getColumnIndex(KEY_IMG_URL))
                val ingredients = cursor.getString(cursor.getColumnIndex(KEY_INGREDIENTS))
                val preparation = cursor.getString(cursor.getColumnIndex(KEY_PREPARATION))
                dishes.add(DishModel(id, name, imgURL, ingredients, preparation))
            } while (cursor.moveToNext())
            cursor.close()
        }
        return dishes
    }

    fun containsDish(id: Int) : Boolean {
        var contains = false
        val cursor = getQuery()
        if (cursor.moveToFirst()) {
            do {
                val curId = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                if (curId == id) {
                    contains = true
                    break
                }
            } while (cursor.moveToNext())
            cursor.close()
        }
        return contains
    }

    private fun getQuery() =
        db.query(TABLE, null, null, null, null, null, null)

    fun addDish(id: Int) {
        for (dish in DishModel.Loaded.get()) {
            if (dish.id == id) {
                val content = ContentValues()
                content.run {
                    put(KEY_ID, dish.id)
                    put(KEY_NAME, dish.name)
                    put(KEY_IMG_URL, dish.img_url)
                    put(KEY_INGREDIENTS, dish.ingredients)
                    put(KEY_PREPARATION, dish.preparation)
                }
                db.insert(TABLE, null, content)
                break
            }
        }
    }

    fun deleteDish(id: Int) {
        db.delete(TABLE, "$KEY_ID = ?", arrayOf(id.toString()))
    }
}