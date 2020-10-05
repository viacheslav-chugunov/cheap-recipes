package com.dev.cheaprecipes.app.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.App
import com.dev.cheaprecipes.app.adapter.CategorySectionsAdapter
import com.dev.cheaprecipes.app.presentation.search.SearchActivity
import com.dev.cheaprecipes.data.repository.DishRepository
import com.dev.cheaprecipes.business.extensions.bindToolbar
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindToolbar()
        bindViewPaper()
    }

    private fun bindViewPaper() {
        category_view_pager.adapter = CategorySectionsAdapter(this, supportFragmentManager)
        category_tab_layout.setupWithViewPager(category_view_pager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when(item.itemId) {
            R.id.search_menu -> {
                startActivity(Intent(this, SearchActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}