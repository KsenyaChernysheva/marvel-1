package com.example.xenya.marvel.network

import com.example.xenya.marvel.entities.Test
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {
    @GET("characters?ts=1&apikey=36d5037b86555fa73124fd832468d1f7&hash=059ec8f38f9d3254cee1e8eade1b5a45")
    fun findAllCharacters(): Single<Test>

    @GET("characters/{id}?ts=1&apikey=36d5037b86555fa73124fd832468d1f7&hash=059ec8f38f9d3254cee1e8eade1b5a45")
    fun findCharacterById(@Path("id") characterId: Int): Single<Test>
}
