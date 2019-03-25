package com.example.xenya.marvel.presenter

import android.view.View
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.xenya.marvel.model.MarvelModel
import com.example.xenya.marvel.view.MainView
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class MainPresenter(private val model: MarvelModel) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        loadCharacters()
    }

    fun onCharacterClick(characterId: Int, view: View) = viewState.navigateToDetailsView(characterId, view)

    private fun loadCharacters() {
        model.loadCharacters()
                .doOnSubscribe { viewState.showLoading() }
                .doAfterTerminate { viewState.hideLoading() }
                .subscribeBy(onSuccess = {
                    viewState.showCharacters(it)
                }, onError = {
                    model.getCharactersFromDb().subscribeBy {
                        viewState.showCharacters(it)
                    }
                })
    }
}
