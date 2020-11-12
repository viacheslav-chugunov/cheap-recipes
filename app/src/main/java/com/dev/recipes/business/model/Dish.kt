package com.dev.recipes.business.model

import androidx.room.Entity


@Entity(tableName = "dish_table", primaryKeys = ["id"])
data class Dish(val id: Int,
                val category: String,
                val name: String,
                val img_url: String,
                val ingredients: String,
                val preparation: String)
