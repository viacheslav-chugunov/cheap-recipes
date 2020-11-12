package com.dev.recipes.app.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.dev.recipes.R
import com.dev.recipes.business.const.Category
import com.dev.recipes.business.model.Dish
import com.squareup.picasso.Picasso

class CardAdapter(private val context: Context,
                  private val items: List<CardItem>,
                  private val listener: Listener) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {


    class CardItem(val id: Int, val title: String, val imageUrl: String)


    interface Listener { fun onItemClick(id: Int) }


    companion object {

        fun forCategories(c: Context, l: Listener) : CardAdapter {
            val items = listOf(
                getCategoryItem(c, Category.HOT),
                getCategoryItem(c, Category.SOUP),
                getCategoryItem(c, Category.DRINK),
                getCategoryItem(c, Category.SALAD),
                getCategoryItem(c, Category.BREAKFAST),
                getCategoryItem(c, Category.SAUCE),
                getCategoryItem(c, Category.DESSERT)
            )
            return CardAdapter(c, items, l)
        }

        private fun getCategoryItem(c: Context, category: Category) : CardItem {
            return CardItem(category.id, c.getString(category.valueRes), category.imgUrl )
        }

        fun forDishes(c: Context, dishes: List<Dish>, l: Listener) : CardAdapter {
            val items = mutableListOf<CardItem>()
            for (dish in dishes)
                items += CardItem(dish.id, dish.name, dish.img_url)
            return CardAdapter(c, items, l)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
        holder.setListener(item, listener)
    }

    override fun getItemCount(): Int = items.count()


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val view: LinearLayout = view.findViewById(R.id.view)
        private val image: ImageView = view.findViewById(R.id.image)
        private val title: TextView = view.findViewById(R.id.title)

        fun setListener(li: CardItem, l: Listener?) {
            l?.let { view.setOnClickListener { l.onItemClick(li.id) } }
        }

        fun setItem(li: CardItem) {
            title.text = li.title
            Picasso.with(context)
                .load(li.imageUrl)
                .error(R.drawable.no_image)
                .into(image)
        }

    }

}