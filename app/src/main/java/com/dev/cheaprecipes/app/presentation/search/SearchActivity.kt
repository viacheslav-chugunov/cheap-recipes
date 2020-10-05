package com.dev.cheaprecipes.app.presentation.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.presentation.category.CategoryFragment
import com.dev.cheaprecipes.app.presentation.category.SearchCategoryFragment
import com.dev.cheaprecipes.business.extensions.bindSearchToolbar
import com.dev.cheaprecipes.business.extensions.bindToolbar
import kotlinx.android.synthetic.main.search_toolbar.*
import java.util.*

class SearchActivity : AppCompatActivity() {

    private var updatableSearch = true
    private var lastEntered = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        bindSearchToolbar(upButton = true)
        lastEntered = search_toolbar_text.text.toString()
        updateFoundDishes()
    }

    private fun updateFoundDishes(delay: Long = 500) {
        Handler().postDelayed({
            val newEntered = search_toolbar_text.text.toString()
            if (updatableSearch) {
                updateFoundDishes(delay)
                if (lastEntered != newEntered) {
                    lastEntered = newEntered
                    updateAdapter()
                }
            }
        }, delay)
    }

    private fun updateAdapter() {
        val fr = supportFragmentManager.findFragmentById(R.id.search_list_fragment) as SearchCategoryFragment
        fr.updateAdapter(search_toolbar_text.text.toString())
    }

    override fun onResume() {
        super.onResume()
        updatableSearch = true
    }

    override fun onPause() {
        super.onPause()
        updatableSearch = false
    }
}