package com.dev.recipes.app.presentation.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dev.recipes.R
import com.dev.recipes.business.extensions.bindToolbar

class CategoryActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        bindToolbar()
        navController = Navigation.findNavController(this, R.id.nav_host)
        title = findViewById(R.id.toolbar_title)
    }

    fun setAllCategoryTitle() { title.text = getString(R.string.app_name) }

    fun setFavouritesCategoryTitle() { title.text = getString(R.string.favourites) }

}