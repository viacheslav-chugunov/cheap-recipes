package com.dev.cheaprecipes.data.service

import com.dev.cheaprecipes.business.model.DishModel
import retrofit2.Response
import retrofit2.http.GET

interface DishService {

    @GET("raw/C75ZyU60")
    suspend fun getDishes() : Response<List<DishModel>>
}