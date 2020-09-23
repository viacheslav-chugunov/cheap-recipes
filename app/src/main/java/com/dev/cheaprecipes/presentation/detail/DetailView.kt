package com.dev.cheaprecipes.presentation.detail

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface DetailView : MvpView {
    fun setImage(imgId: Int)
    fun setTitle(title: String)
    fun setIngredients(ingredients: String)
    fun setPreparation(preparation: String)
}