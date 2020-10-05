package com.dev.cheaprecipes.app.di.component

import com.dev.cheaprecipes.app.presentation.split.SplitActivity
import com.dev.cheaprecipes.app.presentation.category.CategoryFragment
import com.dev.cheaprecipes.app.di.module.RetrofitModule
import com.dev.cheaprecipes.app.di.module.ServiceModule
import com.dev.cheaprecipes.app.presentation.main.MainActivity
import com.dev.cheaprecipes.app.di.module.AppModule
import com.dev.cheaprecipes.app.di.module.RepositoryModule
import com.dev.cheaprecipes.app.presentation.category.FavouritesCategoryFragment
import com.dev.cheaprecipes.app.presentation.detail.DetailPresenter
import com.dev.cheaprecipes.app.presentation.error.NoInternetPermissionActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ServiceModule::class, RetrofitModule::class, RepositoryModule::class,
    AppModule::class])
@Singleton
interface AppComponent {

    // activity
    fun inject(activity: SplitActivity)
    fun inject(activity: NoInternetPermissionActivity)
    fun inject(activity: MainActivity)

    // fragment
    fun inject(fragment: CategoryFragment)
    fun inject(presenter: FavouritesCategoryFragment)

    // presenter
    fun inject(presenter: DetailPresenter)
}