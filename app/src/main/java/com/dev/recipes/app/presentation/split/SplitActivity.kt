package com.dev.recipes.app.presentation.split

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dev.recipes.R

class SplitActivity : AppCompatActivity() {

    lateinit var viewModel: SplitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split)
        viewModel = ViewModelProvider(this).get(SplitViewModel::class.java)
        viewModel.runApp(this)
    }

}