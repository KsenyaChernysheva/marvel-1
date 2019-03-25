package com.example.xenya.marvel

import android.app.Application
import com.example.xenya.marvel.dagger.AppComponent
import com.example.xenya.marvel.dagger.DaggerAppComponent
import com.example.xenya.marvel.database.DatabaseModule
import com.example.xenya.marvel.model.ModelModule
import com.example.xenya.marvel.network.MarvelModule
import com.example.xenya.marvel.presenter.PresenterModule

class App : Application() {
    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .marvelModule(MarvelModule())
                .databaseModule(DatabaseModule(context = applicationContext))
                .modelModule(ModelModule())
                .presenterModule(PresenterModule())
                .build()
    }
}
