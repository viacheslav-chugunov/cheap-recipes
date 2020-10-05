package com.dev.cheaprecipes.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.dev.cheaprecipes.data.db.FavouritesDB.Companion.KEY_ID
import com.dev.cheaprecipes.data.db.FavouritesDB.Companion.KEY_IMG_URL
import com.dev.cheaprecipes.data.db.FavouritesDB.Companion.KEY_INGREDIENTS
import com.dev.cheaprecipes.data.db.FavouritesDB.Companion.KEY_NAME
import com.dev.cheaprecipes.data.db.FavouritesDB.Companion.KEY_PREPARATION

class FavouritesDBHelper(context: Context) : SQLiteOpenHelper(context, TABLE, null, VERSION) {
    companion object {
        const val VERSION = 1
        const val TABLE = "favourites_dishes"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TABLE($KEY_ID integer primary key," +
                "$KEY_NAME text, " +
                "$KEY_IMG_URL integer, " +
                "$KEY_INGREDIENTS text, " +
                "$KEY_PREPARATION text);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists $TABLE")
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
}