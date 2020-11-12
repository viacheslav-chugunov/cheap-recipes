package com.dev.recipes.app.presentation.category.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dev.recipes.R
import com.dev.recipes.app.list.CardListFragment
import com.dev.recipes.app.presentation.category.CategoryActivity
import kotlinx.android.synthetic.main.fragment_favourites_category.*

class FavouritesCategoryFragment : Fragment() {

    lateinit var viewModel: FavouritesCategoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(FavouritesCategoryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_favourites_category, container, false)
    }

    override fun onStart() {
        super.onStart()
        prepareAllButton()
        updateList()
    }

    private fun prepareAllButton() {
        all_button.setOnClickListener {
            val parent = activity as CategoryActivity
            parent.navController.navigate(R.id.allCategoryFragment)
            parent.setAllCategoryTitle()
        }
    }

    private fun updateList() {
        val list = childFragmentManager.findFragmentById(R.id.category_list) as CardListFragment
        list.updateForCategories(viewModel)
    }

}