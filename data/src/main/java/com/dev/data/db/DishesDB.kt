package com.dev.data.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import java.lang.IllegalArgumentException

class DishesDB(context: Context) {

    private val db = DishesDBHelper(context).writableDatabase

    companion object {
        const val TABLE_NAME = "dishes_database"
        const val KEY_ID = "_id"
        const val KEY_NAME = "name"
        const val KEY_IMG_ID = "img_id"
        const val KEY_INGREDIENTS = "ingredients"
        const val KEY_PREPARATION = "preparation"
        const val KEY_IN_FAVOURITES = "in_favourites"
    }

    fun close() = db.close()

    fun getAllNames() : List<String> {
        val cursor = getQueryBy(KEY_NAME)
        val names = mutableListOf<String>()
        if (cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(cursor.getColumnIndex(KEY_NAME)))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return names
    }

    fun getIdBy(name: String) = getStringByNameFromColumn(name, KEY_ID).toInt()

    fun getImgIdBy(name: String) = getStringByNameFromColumn(name, KEY_IMG_ID).toInt()

    fun getIngredientsBy(name: String) = getStringByNameFromColumn(name, KEY_INGREDIENTS)

    fun getPreparationBy(name: String) = getStringByNameFromColumn(name, KEY_PREPARATION)

    fun isInFavouritesBy(name: String) = when(getStringByNameFromColumn(name, KEY_IN_FAVOURITES).toInt()) {
        0 -> false
        else -> true
    }

    private fun getStringByNameFromColumn(name: String, column: String) : String {
        val cursor = getQueryBy(KEY_NAME, column)
        if (cursor.moveToFirst()) {
            do {
                if (name == cursor.getString(cursor.getColumnIndex(KEY_NAME))) {
                    val value = cursor.getString(cursor.getColumnIndex(column))
                    cursor.close()
                    return value
                }
            } while (cursor.moveToNext())
        }
        throw IllegalArgumentException("Dishes database have no name $name")
    }

    fun updateFavourites(id: Int) {
        val cursor = getQueryBy(KEY_ID, KEY_IN_FAVOURITES)
        if (cursor.moveToFirst()) {
            do {
                if (id == cursor.getInt(cursor.getColumnIndex(KEY_ID))) {
                    val inFavourites = cursor.getInt(cursor.getColumnIndex(KEY_IN_FAVOURITES)) != 0
                    val reversedInFavourites = if (inFavourites) 0 else 1
                    val content = ContentValues().apply {
                        put(KEY_IN_FAVOURITES, reversedInFavourites)
                    }
                    db.update(TABLE_NAME, content, "$KEY_ID = ?", arrayOf(id.toString()))
                    cursor.close()
                    return
                }
            } while (cursor.moveToNext())
        }
    }

    private fun getQueryBy(vararg columns: String) : Cursor =
        db.query(TABLE_NAME, columns, null, null, null, null, null)
}