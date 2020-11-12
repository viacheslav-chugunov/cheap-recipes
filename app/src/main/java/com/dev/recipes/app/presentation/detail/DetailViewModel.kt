package com.dev.recipes.app.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.recipes.app.application.App
import com.dev.recipes.business.model.Dish
import com.dev.recipes.data.repository.AllDishRepository
import com.dev.recipes.data.repository.FavouritesDishRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel : ViewModel() {

    // di
    @Inject lateinit var allDishRepository: AllDishRepository
    @Inject lateinit var favouritesDishRepository: FavouritesDishRepository

    val dish = MutableLiveData<Dish>()

    init { App.dagger.inject(this) }

    fun fetchDishById(id: Int) {
        viewModelScope.launch {
            val toInsert = allDishRepository.fetchDishById(id)
            dish.postValue(toInsert)
        }
    }

    fun insertDish() {
        CoroutineScope(Dispatchers.IO).launch {
            dish.value?.let { favouritesDishRepository.insertDish(it) }
        }
    }

    fun deleteDish() {
        CoroutineScope(Dispatchers.IO).launch {
            dish.value?.let { favouritesDishRepository.deleteDish(it) }
        }
    }


}