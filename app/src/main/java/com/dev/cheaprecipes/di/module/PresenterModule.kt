package com.dev.cheaprecipes.di.module

import android.content.Context
import com.dev.cheaprecipes.presentation.categorylist.CategoryListPresenter
import com.dev.cheaprecipes.presentation.detail.DetailPresenter
import com.dev.cheaprecipes.presentation.split.SplitPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class PresenterModule() {

    @Provides
    fun provideSplitPresenter(context: Context) : SplitPresenter {
        return SplitPresenter(context)
    }

    @Provides
    fun provideDetailPresenter() : DetailPresenter {
        return DetailPresenter()
    }

    @Provides
    fun provideCategoryListPresenter(context: Context) : CategoryListPresenter {
        return CategoryListPresenter(context)
    }
}