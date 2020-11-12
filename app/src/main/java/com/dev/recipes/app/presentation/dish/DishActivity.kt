package com.dev.recipes.app.presentation.dish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dev.recipes.R
import com.dev.recipes.app.list.CardListFragment
import com.dev.recipes.business.extensions.bindToolbar
import kotlinx.android.synthetic.main.toolbar.*

class DishActivity : AppCompatActivity() {


    object Extra {
        const val CATEGORY_ID = "category id"
        const val IS_FAVOURITES = "is favourites"
    }


    private lateinit var viewModel: DishViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish)
        bindToolbar(upButton = true)
        setupViewModel()
    }

    private fun setupViewModel() {
        val categoryId = intent.extras!!.getInt(Extra.CATEGORY_ID)
        val isFavourites = intent.extras!!.getBoolean(Extra.IS_FAVOURITES)
        viewModel = ViewModelProvider(this).get(DishViewModel::class.java)
        viewModel.loadDishes(categoryId, isFavourites)
    }

    override fun onStart() {
        super.onStart()
        observeDishes()
    }

    private fun observeDishes() {
        viewModel.dishes.observe(this) {
            val list = supportFragmentManager.findFragmentById(R.id.dish_list) as CardListFragment
            list.updateForDishes(it, viewModel)
        }
    }

}