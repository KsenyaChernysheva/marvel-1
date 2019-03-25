package com.example.xenya.marvel.dagger

import com.example.xenya.marvel.presenter.PresenterModuleWithId
import com.example.xenya.marvel.view.DetailsActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresenterModuleWithId::class])
interface PresenterComponent {
    fun inject(detailsActivity: DetailsActivity)
}
