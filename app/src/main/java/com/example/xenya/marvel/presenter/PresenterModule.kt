package com.example.xenya.marvel.presenter

import com.example.xenya.marvel.model.MarvelModel
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
    @Provides
    fun provideMainPresenter(model: MarvelModel) = MainPresenter(model)
}
