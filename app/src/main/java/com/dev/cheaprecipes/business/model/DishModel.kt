package com.dev.cheaprecipes.business.model

data class DishModel(val id: Int, val name: String, val img_url: String,
                     val ingredients: String, val preparation: String) {

    object Loaded {
        private val models = mutableSetOf<DishModel>()

        fun loadAll(dishes: List<DishModel>) =
            models.addAll(dishes.shuffled())

        fun get() : List<DishModel> =
            models.toList()
    }
}