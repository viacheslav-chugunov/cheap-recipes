package com.dev.cheaprecipes.app.presentation.detail

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface DetailView : MvpView {
    fun setImage(imgURL: String)
    fun setTitle(title: String)
    fun setIngredients(ingredients: String)
    fun setPreparation(preparation: String)
}