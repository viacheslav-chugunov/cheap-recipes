package com.dev.recipes.app.presentation.category.all

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import com.dev.recipes.app.adapter.CardAdapter
import com.dev.recipes.app.presentation.dish.DishActivity

class AllCategoryViewModel(private val app: Application) : AndroidViewModel(app), CardAdapter.Listener {

    // CardAdapter.Listener impl
    override fun onItemClick(id: Int) {
        val intent = Intent(app, DishActivity::class.java)
        intent.putExtra(DishActivity.Extra.CATEGORY_ID, id)
        intent.putExtra(DishActivity.Extra.IS_FAVOURITES, false)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        app.startActivity(intent)
    }

}