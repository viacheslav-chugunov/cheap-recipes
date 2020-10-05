package com.dev.cheaprecipes.app.presentation.detail

import android.graphics.text.LineBreaker
import android.os.Build
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.App
import com.dev.cheaprecipes.business.model.DishModel
import com.dev.cheaprecipes.data.repository.FavouritesDishRepository
import moxy.MvpPresenter
import javax.inject.Inject

class DetailPresenter : MvpPresenter<DetailView>() {

    @Inject lateinit var repository: FavouritesDishRepository

    init { App.appComponent.inject(this) }

    fun displayDetailFor(id: Int) {
        val dishes = if (repository.isInFavourites(id)) repository.getDishes() else DishModel.Loaded.get()
        for (dish in dishes) {
            if (id == dish.id) {
                viewState.setImage(dish.img_url)
                viewState.setTitle(dish.name)
                viewState.setIngredients(dish.ingredients)
                viewState.setPreparation(dish.preparation)
                break
            }
        }
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

    fun updateFavourites(item: MenuItem, index: Int) {
        if (!isInFavourites(index)) {
            repository.addDish(index)
            setRemovableFromFavourites(item)
        } else {
            repository.deleteDish(index)
            setAddableToFavourites(item)
        }
    }

    private fun isInFavourites(dishId: Int) : Boolean {
        val dishes = DishModel.Loaded.get()
        if (dishes.isNotEmpty())
            return repository.isInFavourites(dishId)
        return false
    }

    private fun setRemovableFromFavourites(item: MenuItem) =
        item.run {
            setTitle(R.string.remove_from_favourites)
            setIcon(R.drawable.baseline_thumb_down_black_18dp)
        }

    private fun setAddableToFavourites(item: MenuItem) =
        item.run {
            setTitle(R.string.add_to_favourites)
            setIcon(R.drawable.baseline_thumb_up_black_18dp)
        }
}