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

class IngredientsDetailFragment : Fragment() {

    private lateinit var parent: DetailActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        parent = activity as DetailActivity
        return inflater.inflate(R.layout.fragment_ingredients_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        preparePreparationButton()
        observeDish()
    }

    private fun preparePreparationButton() =
            preparation_button.setOnClickListener {
                parent.navController.navigate(R.id.preparationDetailFragment)
            }

    private fun observeDish() =
            parent.viewModel.dish.observe(this) {
                title.text = it.name
                ingredients.text = it.ingredients
                Picasso.with(requireContext())
                        .load(it.img_url)
                        .error(R.drawable.no_image)
                        .into(image)
            }

}