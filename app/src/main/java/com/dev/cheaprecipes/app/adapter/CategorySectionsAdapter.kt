package com.dev.cheaprecipes.app.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.presentation.category.CategoryFragment
import com.dev.cheaprecipes.app.presentation.category.FavouritesCategoryFragment

class CategorySectionsAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(pos: Int) = when (pos) {
        0 -> CategoryFragment()
        else -> FavouritesCategoryFragment()
    }

    override fun getCount() = 2

    override fun getPageTitle(pos: Int) = when(pos) {
        0 -> context.getString(R.string.all_recipes)
        else -> context.getString(R.string.favourites_recipes)
    }

}