package com.dev.recipes.data.room

import androidx.room.*
import com.dev.recipes.business.model.Dish

@Dao
interface DishDao {

    @Query("SELECT * FROM dish_table")
    fun getDishes() : List<Dish>

    @Query("SELECT * FROM dish_table WHERE id = :id")
    fun fetchDishById(id: Int) : Dish

    @Query("SELECT * FROM dish_table WHERE category = :category")
    fun fetchDishesByCategory(category: String) : List<Dish>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDish(dish: Dish)

    @Delete
    fun deleteDish(dish: Dish)
}