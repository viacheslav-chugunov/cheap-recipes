package com.dev.cheaprecipes.presentation.categorylist

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.cheaprecipes.adapter.CategoryAdapter
import com.dev.cheaprecipes.R
import com.dev.business.listener.CardItemListener
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

open class CategoryListFragment : MvpAppCompatFragment(), CategoryListView {

    @InjectPresenter lateinit var presenter: CategoryListPresenter

    @ProvidePresenter fun providePresenter() = CategoryListPresenter(context!!)

    protected lateinit var view: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_category_list, container, false)
        this.view = (view as RecyclerView)
        this.view.layoutManager = GridLayoutManager(context, 2)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setupAdapter()
    }

    override fun adjustAdapter(listener: CardItemListener) {
        view.adapter = CategoryAdapter.asDefault(context!!, listener)
    }
}