package com.example.xenya.marvel.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MarvelModule {
    companion object {
        private const val WEATHER_URL = "https://gateway.marvel.com/v1/public/"
    }

    @Provides
    @Singleton
    fun getService(retrofit: Retrofit): MarvelService =
            retrofit.create(MarvelService::class.java)

    @Provides
    @Singleton
    fun getRetrofit(converterFactory: GsonConverterFactory,
                    rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit = Retrofit.Builder()
            .baseUrl(WEATHER_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()

    @Provides
    fun getGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun getRxFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()
}
