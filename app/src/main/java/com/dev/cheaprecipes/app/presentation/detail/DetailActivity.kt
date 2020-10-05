package com.dev.cheaprecipes.app.presentation.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.presentation.main.MainActivity
import com.dev.cheaprecipes.app.presentation.main.OfflineMainActivity
import com.dev.cheaprecipes.business.cfg.isOffline
import com.dev.cheaprecipes.business.extensions.bindToolbar
import com.dev.cheaprecipes.business.extensions.startActivityInNewTask
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class DetailActivity : MvpAppCompatActivity(), DetailView {

    object Extra { const val ID = "ID" }

    @InjectPresenter
    lateinit var presenter: DetailPresenter

    private var id: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bindToolbar(upButton = true)
        id = intent.extras!!.getInt(Extra.ID)
        presenter.displayDetailFor(id)
        presenter.justifyTexts(detail_ingredients, detail_preparation)
    }

    override fun setTitle(title: String) { detail_title.text = title }

    override fun setImage(imgURL: String) =
        Picasso.with(this)
            .load(imgURL.trim())
            .into(detail_image)

    override fun setIngredients(ingredients: String) { detail_ingredients.text = ingredients }

    override fun setPreparation(preparation: String) { detail_preparation.text = preparation }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail, menu)
        presenter.setFavourites(menu!!, id)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when(item.itemId) {
            R.id.detail_menu_favourites -> {
                presenter.updateFavourites(item, id)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onBackPressed() = if (isOffline)
        startActivityInNewTask(OfflineMainActivity::class.java)
    else
        startActivityInNewTask(MainActivity::class.java)
}