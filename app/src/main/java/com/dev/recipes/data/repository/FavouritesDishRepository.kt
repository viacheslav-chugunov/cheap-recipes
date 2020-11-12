package com.dev.recipes.data.repository

import com.dev.recipes.business.const.Category
import com.dev.recipes.business.model.Dish
import com.dev.recipes.data.room.DishDao

class FavouritesDishRepository(private val dao: DishDao) {

    fun getDishes() : List<Dish> = dao.getDishes()

    fun fetchDishById(id: Int) : Dish = dao.fetchDishById(id)

    fun fetchDishesByCategory(category: Category) : List<Dish> = dao.fetchDishesByCategory(category.toString())

    fun insertDish(dish: Dish) = dao.insertDish(dish)

    fun deleteDish(dish: Dish) = dao.deleteDish(dish)

}