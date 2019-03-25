package com.example.xenya.marvel.presenter

import com.example.xenya.marvel.model.MarvelModel
import dagger.Module
import dagger.Provides

@Module
class PresenterModuleWithId(val cityId: Int) {

    @Provides
    fun provideDetailsPresenter(model: MarvelModel) = DetailsPresenter(cityId, model)
}
