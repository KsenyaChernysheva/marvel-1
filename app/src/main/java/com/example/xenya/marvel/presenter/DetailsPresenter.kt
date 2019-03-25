package com.example.xenya.marvel.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.xenya.marvel.model.MarvelModel
import com.example.xenya.marvel.view.DetailsView
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class DetailsPresenter(
        val characterId: Int,
        private val model: MarvelModel
) : MvpPresenter<DetailsView>() {

    override fun onFirstViewAttach() {
        model.loadCharacterById(characterId)
                .subscribeBy(onComplete = {}, onError = {
                    viewState.showError()
                })
        model.getCharacterFromDbById(characterId)
                .subscribeBy(onNext = {
                    viewState.showContent(it)
                }, onError = {
                    viewState.showError()
                })
    }
}
