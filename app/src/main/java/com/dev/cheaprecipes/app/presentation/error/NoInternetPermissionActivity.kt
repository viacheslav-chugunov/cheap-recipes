package com.dev.cheaprecipes.app.presentation.error

import android.graphics.ColorFilter
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.App
import com.dev.cheaprecipes.app.presentation.main.MainActivity
import com.dev.cheaprecipes.app.presentation.main.OfflineMainActivity
import com.dev.cheaprecipes.business.cfg.isOffline
import com.dev.cheaprecipes.business.extensions.*
import com.dev.cheaprecipes.business.model.DishModel
import com.dev.cheaprecipes.data.repository.DishRepository
import kotlinx.android.synthetic.main.activity_no_internet_permission.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoInternetPermissionActivity : AppCompatActivity() {

    @Inject lateinit var repository: DishRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_internet_permission)
    }

    fun onClickReconnectButton(view: View) {
        if (hasInternetPermission())
            startActivityAfterLoadingDishes(loadDishes(repository), MainActivity::class.java)
        else {
            no_internet_reconnect_button.visibility = View.GONE
            Handler().postDelayed({
                no_internet_reconnect_button.visibility = View.VISIBLE
            }, 5000)
            showToast(R.string.no_internet, Toast.LENGTH_SHORT)
        }
    }

    fun onClickOfflineButton(view: View) {
        isOffline = true
        startActivityInNewTask(OfflineMainActivity::class.java)
    }
}