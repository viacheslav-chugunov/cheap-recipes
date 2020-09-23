package com.dev.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.dev.data.db.DishesDB.Companion.KEY_ID
import com.dev.data.db.DishesDB.Companion.KEY_IMG_ID
import com.dev.data.db.DishesDB.Companion.KEY_INGREDIENTS
import com.dev.data.db.DishesDB.Companion.KEY_IN_FAVOURITES
import com.dev.data.db.DishesDB.Companion.KEY_NAME
import com.dev.data.db.DishesDB.Companion.KEY_PREPARATION
import com.dev.data.db.DishesDB.Companion.TABLE_NAME


class DishesDBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private const val DB_NAME = "dishes_database"
        private const val DB_VERSION = 6
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {
            it.execSQL("create table $TABLE_NAME($KEY_ID integer primary key autoincrement," +
                    "$KEY_NAME text, " +
                    "$KEY_IMG_ID integer, " +
                    "$KEY_INGREDIENTS text, " +
                    "$KEY_PREPARATION text, " +
                    "$KEY_IN_FAVOURITES integer default 0);")
            DishesDBInitter(it).init()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists $TABLE_NAME")
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
}