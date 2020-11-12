package com.dev.recipes.app.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.recipes.R
import com.dev.recipes.business.extensions.justify
import com.dev.recipes.business.model.Dish
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_ingredients_detail.*
import kotlinx.android.synthetic.main.fragment_preparation_detail.*

class PreparationDetailFragment : Fragment() {

    private lateinit var parent: DetailActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        parent = activity as DetailActivity
        return inflater.inflate(R.layout.fragment_preparation_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        prepareIngredientsButton()
        observeDish()
    }

    private fun prepareIngredientsButton() =
            ingredients_button.setOnClickListener {
                parent.navController.navigate(R.id.ingredientsDetailFragment)
            }

    private fun observeDish() =
            parent.viewModel.dish.observe(this) {
                preparation.text = it.preparation
                preparation.justify()
            }

}