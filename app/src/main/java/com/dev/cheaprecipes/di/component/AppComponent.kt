package com.dev.cheaprecipes.di.component

import com.dev.cheaprecipes.di.module.AppModule
import com.dev.cheaprecipes.di.module.DBModule
import com.dev.cheaprecipes.di.module.PresenterModule
import com.dev.cheaprecipes.di.module.RepositoryModule
import com.dev.cheaprecipes.presentation.category.CategoryActivity
import com.dev.cheaprecipes.presentation.categorylist.CategoryListFragment
import com.dev.cheaprecipes.presentation.categorylist.CategoryListPresenter
import com.dev.cheaprecipes.presentation.detail.DetailActivity
import com.dev.cheaprecipes.presentation.detail.DetailPresenter
import com.dev.cheaprecipes.presentation.split.SplitActivity
import com.dev.cheaprecipes.presentation.split.SplitPresenter
import com.dev.data.db.DishesDB
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class, DBModule::class, PresenterModule::class, AppModule::class])
@Singleton
interface AppComponent {

    // activity
    fun inject(activity: SplitActivity)
    fun inject(activity: CategoryActivity)
    fun inject(activity: DetailActivity)

    // fragment
    fun inject(fragment: CategoryListFragment)

    //presenter
    fun inject(presenter: SplitPresenter)
    fun inject(presenter: CategoryListPresenter)
    fun inject(presenter: DetailPresenter)

    // db
    fun inject(db: DishesDB)
}