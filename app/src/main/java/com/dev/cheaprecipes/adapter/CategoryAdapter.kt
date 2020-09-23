package com.dev.cheaprecipes.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.dev.cheaprecipes.R
import com.dev.business.listener.CardItemListener
import com.dev.data.repository.DishesRepository

open class CategoryAdapter private constructor(private val cardDishes: List<DishesRepository.CardDish>,
                                               private val listener: CardItemListener) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    companion object {
        fun asDefault(context: Context, listener: CardItemListener) : CategoryAdapter {
            val cardDishes: List<DishesRepository.CardDish> = DishesRepository(context).getCardDishes()
            return CategoryAdapter(cardDishes, listener)
        }

        fun asFavourites(context: Context, listener: CardItemListener) : CategoryAdapter {
            val cardDishes: List<DishesRepository.CardDish> = DishesRepository(context).getFavouritesCardDishes()
            return CategoryAdapter(cardDishes, listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cardDishes[position]
        holder.setImage(item.imgId)
        holder.setTitle(item.name)
        holder.setListener(item.id)
    }

    override fun getItemCount() = cardDishes.count()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val card: CardView = view.findViewById(R.id.item_card)
        private val image: ImageView = view.findViewById(R.id.item_image)
        private val title: TextView = view.findViewById(R.id.item_title)

        fun setImage(drawableRes: Int) = image.setImageResource(drawableRes)
        fun setTitle(title: String) { this.title.text = title }
        fun setListener(id: Int) { card.setOnClickListener { listener.onItemClick(id) } }
    }
}