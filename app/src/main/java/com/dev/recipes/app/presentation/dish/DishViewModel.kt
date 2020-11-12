package com.dev.recipes.app.presentation.dish

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.recipes.app.adapter.CardAdapter
import com.dev.recipes.app.application.App
import com.dev.recipes.app.presentation.detail.DetailActivity
import com.dev.recipes.business.const.Category
import com.dev.recipes.business.model.Dish
import com.dev.recipes.data.repository.AllDishRepository
import com.dev.recipes.data.repository.FavouritesDishRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject

class DishViewModel(private val app: Application) : AndroidViewModel(app), CardAdapter.Listener {

    // di
    @Inject lateinit var allDishRepository: AllDishRepository
    @Inject lateinit var favouritesDishRepository: FavouritesDishRepository

    val dishes = MutableLiveData<List<Dish>>()

    init { App.dagger.inject(this) }

    fun loadDishes(categoryId: Int, isFavourites: Boolean) {
        val category = Category.getById(categoryId)
        if (isFavourites)
            loadDishesFromDb(category)
        else
            loadDishesFromApi(category)
    }

    private fun loadDishesFromDb(category: Category) {
        CoroutineScope(Dispatchers.IO).launch {
            val dishesByCategory = favouritesDishRepository.fetchDishesByCategory(category)
            dishes.postValue(dishesByCategory)
        }
    }

    private fun loadDishesFromApi(category: Category) {
        viewModelScope.launch {
            val dishesByCategory = allDishRepository.fetchDishesByCategory(category)
            dishes.postValue(dishesByCategory)
        }
    }

    // CardAdapter.Listener impl
    override fun onItemClick(id: Int) {
        val intent = Intent(app, DetailActivity::class.java)
        intent.putExtra(DetailActivity.Extra.DISH_ID, id)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        app.startActivity(intent)
    }

}