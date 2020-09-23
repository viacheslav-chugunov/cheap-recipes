package com.dev.cheaprecipes.presentation.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.extensions.bindToolbar
import com.dev.cheaprecipes.extensions.startActivityWithoutBackStack
import com.dev.cheaprecipes.presentation.category.CategoryActivity
import kotlinx.android.synthetic.main.activity_detail.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class DetailActivity : MvpAppCompatActivity(), DetailView {

    object Extra { const val ID = "ID" }

    @InjectPresenter lateinit var presenter: DetailPresenter

    @ProvidePresenter fun providePresenter() = DetailPresenter()

    private var dishId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bindToolbar(upButton = true)
        dishId = intent.extras!!.getInt(Extra.ID)
        presenter.displayDetailFor(dishId)
        presenter.justifyTexts(detail_ingredients, detail_preparation)
    }

    override fun setTitle(title: String) { detail_title.text = title }

    override fun setImage(imgId: Int) = detail_image.setImageDrawable(ContextCompat.getDrawable(this, imgId))

    override fun setIngredients(ingredients: String) { detail_ingredients.text = ingredients }

    override fun setPreparation(preparation: String) { detail_preparation.text = preparation }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail, menu)
        presenter.setFavourites(menu!!, dishId)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        R.id.detail_menu_favourites -> {
            presenter.updateFavourites(item, dishId)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() = startActivityWithoutBackStack(CategoryActivity::class.java)
}