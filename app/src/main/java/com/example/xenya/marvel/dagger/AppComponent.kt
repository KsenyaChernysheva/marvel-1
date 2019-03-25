package com.example.xenya.marvel.dagger

import com.example.xenya.marvel.database.DatabaseModule
import com.example.xenya.marvel.model.ModelModule
import com.example.xenya.marvel.network.MarvelModule
import com.example.xenya.marvel.presenter.MainPresenter
import com.example.xenya.marvel.presenter.PresenterModule
import com.example.xenya.marvel.presenter.PresenterModuleWithId
import com.example.xenya.marvel.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MarvelModule::class, DatabaseModule::class,
    ModelModule::class, PresenterModule::class])
interface AppComponent {
    fun plus(module: PresenterModuleWithId): PresenterComponent
    fun inject(mainActivity: MainActivity)

    fun getMAinPresenter(): MainPresenter
}
