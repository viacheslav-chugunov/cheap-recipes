package com.dev.cheaprecipes.presentation.split

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface SplitView : MvpView {
    fun startNextActivity()
}