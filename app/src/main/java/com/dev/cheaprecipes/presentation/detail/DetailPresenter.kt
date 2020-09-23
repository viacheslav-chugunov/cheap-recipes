package com.dev.cheaprecipes.presentation.detail

import android.graphics.text.LineBreaker
import android.os.Build
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.dev.cheaprecipes.App
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.di.component.AppComponent
import com.dev.data.repository.DishesRepository
import moxy.MvpPresenter
import javax.inject.Inject

class DetailPresenter : MvpPresenter<DetailView>() {

    @Inject lateinit var dishesRepository: DishesRepository

    init { App.appComponent.inject(this) }

    fun displayDetailFor(dishId: Int) {
        val dish = dishesRepository.getFullDish(dishId)
        viewState.setImage(dish.imgId)
        viewState.setTitle(dish.name)
        viewState.setIngredients(dish.ingredients)
        viewState.setPreparation(dish.preparation)
    }

    fun justifyTexts(vararg textViews: TextView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
            textViews.forEach { it.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD }
    }

    fun setFavourites(menu: Menu, dishId: Int) {
        val item = menu.findItem(R.id.detail_menu_favourites)
        if (isInFavourites(dishId))
            setRemovableFromFavourites(item)
        else
            setAddableToFavourites(item)
    }

    fun updateFavourites(item: MenuItem, dishId: Int) {
        dishesRepository.updateFavouritesBy(dishId)
        if (isInFavourites(dishId))
            setRemovableFromFavourites(item)
        else
            setAddableToFavourites(item)
    }

    private fun isInFavourites(dishId: Int) : Boolean {
        val dish = dishesRepository.getCardDish(dishId)
        return dishesRepository.isInFavouritesBy(dish.name)
    }

    private fun setRemovableFromFavourites(item: MenuItem) = item.run {
        setTitle(R.string.remove_from_favourites)
        setIcon(R.drawable.baseline_thumb_down_black_18dp)
    }

    private fun setAddableToFavourites(item: MenuItem) = item.run {
        setTitle(R.string.add_to_favourites)
        setIcon(R.drawable.baseline_thumb_up_black_18dp)
    }
}