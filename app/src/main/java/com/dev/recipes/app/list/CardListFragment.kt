package com.dev.recipes.app.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dev.recipes.R
import com.dev.recipes.app.adapter.CardAdapter
import com.dev.recipes.business.model.Dish

class CardListFragment : Fragment() {

    private lateinit var recycler: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        recycler = inflater.inflate(R.layout.fragment_card_list, container, false) as RecyclerView
        recycler.layoutManager = LinearLayoutManager(requireContext())
        return recycler
    }

    fun updateForCategories(listener: CardAdapter.Listener) {
        recycler.adapter = CardAdapter.forCategories(requireContext(), listener)
    }

    fun updateForDishes(dishes: List<Dish>, listener: CardAdapter.Listener) {
        recycler.adapter = CardAdapter.forDishes(requireContext(), dishes, listener)
    }

}