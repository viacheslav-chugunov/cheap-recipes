package com.dev.cheaprecipes.app.presentation.category

import com.dev.cheaprecipes.app.adapter.CategoryAdapter

class FavouritesCategoryFragment : CategoryFragment() {

    override fun updateAdapter() {
        val listener = presenter.getAdapterListener(context!!)
        recycleView.adapter = CategoryAdapter.favouritesDishes(context!!, listener)
    }
}