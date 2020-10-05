package com.dev.cheaprecipes.app.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.dev.cheaprecipes.R
import com.dev.cheaprecipes.app.listener.CategoryListener
import com.dev.cheaprecipes.business.cfg.isOffline
import com.dev.cheaprecipes.business.model.DishModel
import com.dev.cheaprecipes.data.repository.FavouritesDishRepository
import com.squareup.picasso.Picasso
import java.util.*

open class CategoryAdapter private constructor(private val context: Context,
                                               private var dishes: List<DishModel>,
                                               private val listener: CategoryListener) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    init { dishes = dishes.reversed() }

    companion object {
        fun allDishes(context: Context, listener: CategoryListener) : CategoryAdapter =
            CategoryAdapter(context, DishModel.Loaded.get(), listener)

        fun favouritesDishes(context: Context, listener: CategoryListener) : CategoryAdapter =
            CategoryAdapter(context, FavouritesDishRepository(context).getDishes(), listener)

        fun foundDishes(context: Context, listener: CategoryListener, toSearch: String) : CategoryAdapter {
            val founded = mutableListOf<DishModel>()
            val dishes = if (isOffline)
                FavouritesDishRepository(context).getDishes()
            else
                DishModel.Loaded.get()
            dishes.forEach {
                val convertedName = it.name.toLowerCase(Locale.getDefault()).trim()
                val convertedToSearch = toSearch.toLowerCase(Locale.getDefault()).trim()
                if (convertedName.contains(convertedToSearch))
                    founded.add(it)
            }
            return CategoryAdapter(context, founded, listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishes[position]
        holder.setImage(dish.img_url)
        holder.setTitle(dish.name)
        holder.setListener(dish.id)
    }

    override fun getItemCount() = dishes.count()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val card: CardView = view.findViewById(R.id.item_card)
        private val image: ImageView = view.findViewById(R.id.item_image)
        private val title: TextView = view.findViewById(R.id.item_title)

        fun setImage(url: String) =
            Picasso.with(context)
                .load(url.trim())
                .into(image)

        fun setTitle(title: String) { this.title.text = title }

        fun setListener(id: Int) { card.setOnClickListener { listener.onCategoryItemClick(id) } }
    }
}