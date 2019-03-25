package com.example.xenya.marvel.model

import com.example.xenya.marvel.database.AppDatabase
import com.example.xenya.marvel.network.MarvelService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModelModule {

    @Provides
    @Singleton
    fun getWeatherModel(appDatadase: AppDatabase, marvelService: MarvelService): MarvelModel =
            MarvelModel(appDatadase, marvelService)
}
