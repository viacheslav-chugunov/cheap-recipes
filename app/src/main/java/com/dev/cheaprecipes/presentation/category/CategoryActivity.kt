package com.dev.cheaprecipes.presentation.category

import android.os.Bundle
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.adapter.CategorySectionsAdapter
import com.dev.cheaprecipes.extensions.bindToolbar
import kotlinx.android.synthetic.main.activity_category.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class CategoryActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        bindToolbar()
        bindViewPaper()
    }

    private fun bindViewPaper() {
        category_view_pager.adapter = CategorySectionsAdapter(this, supportFragmentManager)
        category_tab_layout.setupWithViewPager(category_view_pager)
    }
}