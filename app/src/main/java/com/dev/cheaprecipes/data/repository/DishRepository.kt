package com.dev.cheaprecipes.data.repository

import com.dev.cheaprecipes.business.model.DishModel
import com.dev.cheaprecipes.data.service.DishService
import retrofit2.Response

class DishRepository(private val service: DishService) {

    suspend fun getDishes() : Response<List<DishModel>> =
        service.getDishes()
}