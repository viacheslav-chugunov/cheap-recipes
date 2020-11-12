package com.dev.recipes.app.presentation.category.all

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dev.recipes.R
import com.dev.recipes.app.list.CardListFragment
import com.dev.recipes.app.presentation.category.CategoryActivity
import kotlinx.android.synthetic.main.fragment_all_category.*


class AllCategoryFragment : Fragment() {

    lateinit var viewModel: AllCategoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(AllCategoryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_all_category, container, false)
    }

    override fun onStart() {
        super.onStart()
        prepareFavouritesButton()
        updateList()
    }

    private fun prepareFavouritesButton() {
        favourites_button.setOnClickListener {
            val parent = activity as CategoryActivity
            parent.navController.navigate(R.id.favouritesCategoryFragment)
            parent.setFavouritesCategoryTitle()
        }
    }

    private fun updateList() {
        val list = childFragmentManager.findFragmentById(R.id.category_list) as CardListFragment
        list.updateForCategories(viewModel)
    }

}