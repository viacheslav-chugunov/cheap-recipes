package com.dev.cheaprecipes.app.presentation.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.App
import com.dev.cheaprecipes.app.adapter.CategoryAdapter
import com.dev.cheaprecipes.data.repository.DishRepository
import com.dev.cheaprecipes.data.service.DishService
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import javax.inject.Inject

open class CategoryFragment : MvpAppCompatFragment(), CategoryView {

    @InjectPresenter lateinit var presenter: CategoryPresenter

    protected lateinit var recycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        recycleView = inflater.inflate(R.layout.fragment_category, container, false) as RecyclerView
        recycleView.layoutManager = LinearLayoutManager(context)
        updateAdapter()
        return recycleView
    }

    override fun updateAdapter() {
        val listener = presenter.getAdapterListener(context!!)
        recycleView.adapter = CategoryAdapter.allDishes(context!!, listener)
    }
}