package com.dev.recipes.app.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dev.recipes.R
import com.dev.recipes.business.extensions.bindToolbar

class DetailActivity : AppCompatActivity() {


    object Extra { const val DISH_ID = "dish id" }


    lateinit var navController: NavController
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bindToolbar(upButton = true)
        navController = Navigation.findNavController(this, R.id.nav_host)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val dishId = intent.extras!!.getInt(Extra.DISH_ID)
        viewModel.fetchDishById(dishId)
    }

    // Menu impl
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.delail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favourites_item -> {
                viewModel.insertDish()
                // TODO
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}