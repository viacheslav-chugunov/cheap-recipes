package com.dev.cheaprecipes.presentation.categorylist

import android.content.Context
import android.content.Intent
import com.dev.cheaprecipes.presentation.detail.DetailActivity
import com.dev.business.listener.CardItemListener
import moxy.MvpPresenter

class CategoryListPresenter(private val context: Context) : MvpPresenter<CategoryListView>(), CardItemListener {

    fun setupAdapter() = viewState.adjustAdapter(this)

    // Card item listener implementation
    override fun onItemClick(id: Int) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.Extra.ID, id)
        context.startActivity(intent)
    }
}