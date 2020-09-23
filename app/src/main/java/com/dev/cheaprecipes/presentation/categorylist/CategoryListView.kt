package com.dev.cheaprecipes.presentation.categorylist

import com.dev.business.listener.CardItemListener
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface CategoryListView : MvpView {
    fun adjustAdapter(listener: CardItemListener)
}