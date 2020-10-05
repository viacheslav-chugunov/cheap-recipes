package com.dev.cheaprecipes.app.presentation.category

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface CategoryView : MvpView {
    fun updateAdapter()
}