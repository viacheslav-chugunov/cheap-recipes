package com.dev.recipes.app.di.component

import com.dev.recipes.app.di.module.*
import com.dev.recipes.app.presentation.category.all.AllCategoryFragment
import com.dev.recipes.app.presentation.category.CategoryActivity
import com.dev.recipes.app.presentation.category.all.AllCategoryViewModel
import com.dev.recipes.app.presentation.detail.DetailActivity
import com.dev.recipes.app.presentation.detail.DetailViewModel
import com.dev.recipes.app.presentation.dish.DishViewModel
import com.dev.recipes.app.presentation.split.SplitActivity
import dagger.Component
import javax.inject.Singleton


@Component(modules = [
    AppModule::class,
    RetrofitModule::class,
    ApiModule::class,
    RepositoryModule::class,
    RoomModule::class
])
@Singleton
interface AppComponent {

    // Activity
    fun inject(a: SplitActivity)
    fun inject(a: CategoryActivity)
    fun inject(a: DetailActivity)

    // Fragment
    fun inject(f: AllCategoryFragment)

    // ViewModel
    fun inject(vm: AllCategoryViewModel)
    fun inject(vm: DishViewModel)
    fun inject(vm: DetailViewModel)
}