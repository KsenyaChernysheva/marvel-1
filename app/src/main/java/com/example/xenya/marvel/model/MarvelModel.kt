package com.example.xenya.marvel.model

import com.example.xenya.marvel.database.AppDatabase
import com.example.xenya.marvel.entities.Result
import com.example.xenya.marvel.network.MarvelService
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MarvelModel(
        private val appDatabase: AppDatabase,
        private val marvelService: MarvelService
) {

    fun saveCharactersInDatabase(characters: List<Result?>) =
            appDatabase.getMarvelDao().saveAll(characters)

    fun getCharactersFromDb(): Single<List<Result>> =
            appDatabase.getMarvelDao()
                    .getAll()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    fun getCharacterFromDbById(characterId: Int): Flowable<Result> =
            appDatabase.getMarvelDao()
                    .getCharacterById(characterId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    fun loadCharacters(): Single<List<Result?>> =
            marvelService
                    .findAllCharacters()
                    .subscribeOn(Schedulers.io())
                    .map { it.data?.results }
                    .map {
                        saveCharactersInDatabase(it)
                        it
                    }
                    .observeOn(AndroidSchedulers.mainThread())

    fun loadCharacterById(characterId: Int): Completable =
            marvelService
                    .findCharacterById(characterId)
                    .map { it.data?.results }
                    .map {
                        saveCharactersInDatabase(it)
                        it
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .ignoreElement()
}
