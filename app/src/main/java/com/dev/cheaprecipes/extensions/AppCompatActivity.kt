package com.dev.cheaprecipes.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.dev.cheaprecipes.R
import kotlinx.android.synthetic.main.toolbar.*

fun AppCompatActivity.bindToolbar(title: String = getString(R.string.app_name), upButton: Boolean = false) {
    setSupportActionBar(toolbar)
    toolbar_title.text = title
    supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
}

fun AppCompatActivity.startActivityWithoutBackStack(newActivity: Class<*>) {
    startActivity(Intent(this, newActivity).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
    })
    finish()
}