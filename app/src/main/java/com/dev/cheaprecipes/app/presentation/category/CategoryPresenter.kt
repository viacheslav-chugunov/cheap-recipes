package com.dev.cheaprecipes.app.presentation.category

import android.content.Context
import android.content.Intent
import com.dev.cheaprecipes.app.listener.CategoryListener
import com.dev.cheaprecipes.app.presentation.detail.DetailActivity
import moxy.MvpPresenter

class CategoryPresenter : MvpPresenter<CategoryView>() {

    fun getAdapterListener(context: Context) : CategoryListener =
        object : CategoryListener {
            override fun onCategoryItemClick(dishId: Int) {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.Extra.ID, dishId)
                context.startActivity(intent)
            }
        }
}