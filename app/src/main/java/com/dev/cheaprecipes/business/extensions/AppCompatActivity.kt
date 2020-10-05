package com.dev.cheaprecipes.business.extensions

import android.content.Intent
import android.graphics.PorterDuff
import android.net.ConnectivityManager
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.presentation.main.MainActivity
import com.dev.cheaprecipes.business.model.DishModel
import com.dev.cheaprecipes.data.repository.DishRepository
import kotlinx.android.synthetic.main.search_toolbar.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.toolbar
import kotlinx.android.synthetic.main.toolbar.toolbar_title
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun AppCompatActivity.bindToolbar(title: String = getString(R.string.app_name), upButton: Boolean = false) {
    setSupportActionBar(toolbar)
    toolbar_title.text = title
    supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
}

fun AppCompatActivity.bindSearchToolbar(title: String = getString(R.string.app_name), upButton: Boolean = false) {
    setSupportActionBar(search_toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
}

fun AppCompatActivity.startActivityInNewTask(newActivity: Class<*>) {
    val intent = Intent(this, newActivity)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
    startActivity(intent)
    finish()
}

fun AppCompatActivity.hasInternetPermission(): Boolean {
    val cm = getSystemService(AppCompatActivity.CONNECTIVITY_SERVICE) as ConnectivityManager
    var wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
    if (wifiInfo != null && wifiInfo.isConnected)
        return true
    wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
    if (wifiInfo != null && wifiInfo.isConnected)
        return true
    wifiInfo = cm.activeNetworkInfo
    return wifiInfo != null && wifiInfo.isConnected
}

fun AppCompatActivity.startActivityAfterLoadingDishes(dishesLoadingJob: Job, newActivity: Class<*>) {
    Handler().postDelayed({
        if (dishesLoadingJob.isActive)
            startActivityAfterLoadingDishes(dishesLoadingJob, newActivity)
        else
            startActivityInNewTask(newActivity)
    }, 500)
}

fun AppCompatActivity.loadDishes(repository: DishRepository) =
    CoroutineScope(Dispatchers.IO).launch {
        val request = repository.getDishes()
        if (request.isSuccessful)
            DishModel.Loaded.loadAll(request.body()!!)
    }

fun AppCompatActivity.showToast(strRes: Int, duration: Int) {
    val toast = Toast.makeText(this, strRes, duration)
    toast.view.run {
        background.setColorFilter(getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN)
        findViewById<TextView>(android.R.id.message).setTextColor(getColor(R.color.colorAccent))
    }
    toast.show()
}