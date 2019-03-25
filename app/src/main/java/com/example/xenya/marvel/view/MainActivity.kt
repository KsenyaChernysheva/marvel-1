package com.example.xenya.marvel.view

import android.app.ActivityOptions
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.xenya.marvel.App
import com.example.xenya.marvel.R
import com.example.xenya.marvel.entities.Result
import com.example.xenya.marvel.presenter.MainPresenter
import com.example.xenya.marvel.view.adapter.MarvelListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showError() = Toast.makeText(this, "Error occured. Show data from database", Toast.LENGTH_SHORT).show()

    override fun showLoading() {
        pb_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
    }

    override fun showCharacters(characters: List<Result?>) {
        rv_character.adapter = MarvelListAdapter(characters) { characters, view ->
            presenter.onCharacterClick(characters, view)
        }
    }

    override fun navigateToDetailsView(characterId: Int, view: View) {
        val transitionName = getString(R.string.image)
        val transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, view, transitionName)

        startActivity(DetailsActivity.getIntent(this, characterId), transitionActivityOptions.toBundle())
    }
}
