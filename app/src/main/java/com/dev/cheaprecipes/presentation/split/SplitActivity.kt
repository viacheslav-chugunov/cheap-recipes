package com.dev.cheaprecipes.presentation.split

import android.os.Bundle
import android.os.Handler
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.extensions.startActivityWithoutBackStack
import com.dev.cheaprecipes.presentation.category.CategoryActivity
import com.dev.data.db.DishesDB
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class SplitActivity : MvpAppCompatActivity(), SplitView {

    @InjectPresenter lateinit var presenter: SplitPresenter

    @ProvidePresenter fun providePresenter() = SplitPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split)
        presenter.initInterstitialAd()
        Handler().postDelayed({ presenter.startNewActivityWithAdIfLoaded() }, 1500)
    }

    override fun startNextActivity() = startActivityWithoutBackStack(CategoryActivity::class.java)
}