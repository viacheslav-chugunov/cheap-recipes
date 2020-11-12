package com.dev.recipes.data.retrofit

import com.dev.recipes.business.model.Dish
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DishApi {

    @GET("raw/edKqt4WX")
    suspend fun getDishes() : Response<List<Dish>>

//    @GET("raw/edKqt4WX")
//    suspend fun getDishById(@Query("id") id: Int) : Response<Dish>
//
//    @GET("raw/edKqt4WX")
//    suspend fun getDishesByCategory(@Query("category") category: String) : Response<List<Dish>>
}