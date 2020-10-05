package com.dev.cheaprecipes.app.presentation.category

import com.dev.cheaprecipes.app.adapter.CategoryAdapter

class SearchCategoryFragment : CategoryFragment() {

    override fun updateAdapter() {
        updateAdapter("")
    }

    fun updateAdapter(toSearch: String) {
        if (toSearch.isNotBlank()) {
            val listener = presenter.getAdapterListener(context!!)
            recycleView.adapter = CategoryAdapter.foundDishes(context!!, listener, toSearch)
        }
    }
}