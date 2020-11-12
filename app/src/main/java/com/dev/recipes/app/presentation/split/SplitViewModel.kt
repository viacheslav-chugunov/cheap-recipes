package com.dev.recipes.app.presentation.split

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import com.dev.recipes.app.presentation.category.CategoryActivity

class SplitViewModel(private val app: Application) : AndroidViewModel(app) {

    fun runApp(a: Activity) {
        val intent = Intent(a, CategoryActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        a.startActivity(intent)
        a.finish()
    }

}