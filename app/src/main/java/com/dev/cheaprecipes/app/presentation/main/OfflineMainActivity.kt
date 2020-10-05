package com.dev.cheaprecipes.app.presentation.main

import android.os.Bundle
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.business.extensions.bindToolbar

class OfflineMainActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline_main)
        bindToolbar()
    }
}