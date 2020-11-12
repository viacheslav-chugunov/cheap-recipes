package com.dev.recipes.data.repository

import com.dev.recipes.business.const.Category
import com.dev.recipes.business.model.Dish
import com.dev.recipes.data.retrofit.DishApi
import java.lang.IllegalArgumentException

class AllDishRepository(private val api: DishApi) {

    suspend fun getDishes() : List<Dish> {
        val request = api.getDishes()
        if (request.isSuccessful)
            return request.body()?.shuffled() ?: emptyList()
        return emptyList()
    }

    suspend fun fetchDishById(id: Int) : Dish {
        for (dish in getDishes())
            if (dish.id == id)
                return dish
        throw IllegalArgumentException("Cannot find such id: $id")
    }

    suspend fun fetchDishesByCategory(category: Category): List<Dish> {
        val byCategory = mutableListOf<Dish>()
        for (dish in getDishes()) {
            if (dish.category == category.toString())
                byCategory += dish
        }
        return byCategory
    }
}