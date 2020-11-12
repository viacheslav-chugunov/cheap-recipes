package com.dev.recipes.business.extensions

import androidx.appcompat.app.AppCompatActivity
import com.dev.recipes.R
import kotlinx.android.synthetic.main.toolbar.*

fun AppCompatActivity.bindToolbar(title: String = getString(R.string.app_name),
                                  upButton: Boolean = false) {
    setSupportActionBar(toolbar)
    toolbar_title.text = title
    supportActionBar?.setDisplayShowTitleEnabled(false)
    supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
}