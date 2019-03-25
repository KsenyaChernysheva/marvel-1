package com.example.xenya.marvel.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.example.xenya.marvel.App
import com.example.xenya.marvel.R
import com.example.xenya.marvel.entities.Result
import com.example.xenya.marvel.presenter.DetailsPresenter
import com.example.xenya.marvel.presenter.PresenterModuleWithId
import com.example.xenya.marvel.utils.PORTRAIT_XLARGE
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : MvpAppCompatActivity(), DetailsView {

    @Inject
    @InjectPresenter
    lateinit var presenter: DetailsPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    companion object {
        private const val EXTRA_CITY_ID = "cityid"

        fun getIntent(context: Context, cityId: Int) =
                Intent(context, DetailsActivity::class.java).apply {
                    putExtra(EXTRA_CITY_ID, cityId)
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent
                ?.plus(PresenterModuleWithId(intent.getIntExtra(EXTRA_CITY_ID, 0)))
                ?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    override fun showError() =
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()

    override fun showContent(character: Result) {
        Glide.with(this)
                .load(character.thumbnail?.path + PORTRAIT_XLARGE + character.thumbnail?.extension)
                .into(iv_character)
        tv_name_character.text = character.name
        tv_comics.text = character.comics?.available
        tv_series.text = character.series?.available
        tv_stories.text = character.stories?.available
        tv_events.text = character.events?.available
    }
}
