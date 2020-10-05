package com.dev.cheaprecipes.app.presentation.split

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.App
import com.dev.cheaprecipes.app.presentation.error.NoInternetPermissionActivity
import com.dev.cheaprecipes.app.presentation.main.MainActivity
import com.dev.cheaprecipes.business.extensions.hasInternetPermission
import com.dev.cheaprecipes.business.extensions.loadDishes
import com.dev.cheaprecipes.business.extensions.startActivityAfterLoadingDishes
import com.dev.cheaprecipes.business.extensions.startActivityInNewTask
import com.dev.cheaprecipes.data.repository.DishRepository
import javax.inject.Inject


class SplitActivity : AppCompatActivity() {

    @Inject lateinit var repository: DishRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split)
        if (hasInternetPermission())
            startActivityAfterLoadingDishes(loadDishes(repository), MainActivity::class.java)
        else
            startActivityInNewTask(NoInternetPermissionActivity::class.java)
    }
}