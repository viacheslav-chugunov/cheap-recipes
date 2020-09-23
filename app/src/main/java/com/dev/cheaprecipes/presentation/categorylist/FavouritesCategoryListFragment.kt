package com.dev.cheaprecipes.presentation.categorylist

import com.dev.business.listener.CardItemListener
import com.dev.cheaprecipes.adapter.CategoryAdapter

class FavouritesCategoryListFragment : CategoryListFragment() {

    override fun adjustAdapter(listener: CardItemListener) {
        view.adapter = CategoryAdapter.asFavourites(context!!, listener)
    }
}