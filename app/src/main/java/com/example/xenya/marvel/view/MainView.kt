package com.example.xenya.marvel.view

import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.xenya.marvel.entities.Result

interface MainView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showLoading()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun hideLoading()

    @StateStrategyType(SingleStateStrategy::class)
    fun showCharacters(characters: List<Result?>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToDetailsView(characterId: Int, sharedView: View)
}
