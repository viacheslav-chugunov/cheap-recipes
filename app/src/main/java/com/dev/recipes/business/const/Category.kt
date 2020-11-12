package com.dev.recipes.business.const

import com.dev.recipes.R

enum class Category(val valueRes: Int, val id: Int, val imgUrl: String) {
    HOT(
        R.string.hot, 0,
            "https://i.ytimg.com/vi/KrToV2NHxhQ/maxresdefault.jpg"),
    SOUP(R.string.soup, 1,
            "https://eda.ru/img/eda/c620x415i/s1.eda.ru/StaticContent/Photos/160729115308/160809134027/p_O.jpg"),
    DRINK(R.string.drink, 2,
            "https://art-lunch.ru/content/uploads/2019/03/imbirniy_napitok_001.jpg"),
    SALAD(R.string.salad, 3,
            "https://www.bulochka.ru/wp-content/uploads/2019/10/salat-s-avokado-syomgoj-i-pomidorami.jpg"),
    BREAKFAST(R.string.breakfast, 4,
            "https://www.gastronom.ru/binfiles/images/20150722/b27b3f78.jpg"),
    SAUCE(R.string.sauce, 5,
            "https://eda.ru/img/eda/c620x415i/s2.eda.ru/StaticContent/Photos/120131085053/120213184527/p_O.jpg"),
    DESSERT(R.string.dessert, 6,
            "https://www.koolinar.ru/all_image/recipes/132/132902/recipe_40704ce2-7e5c-47ad-b1e2-d863a6780749_large.jpg");


    companion object {

        fun getById(categoryId: Int) : Category {
            return when (categoryId) {
                HOT.id -> HOT
                SOUP.id -> SOUP
                DRINK.id -> DRINK
                SALAD.id -> SALAD
                BREAKFAST.id -> BREAKFAST
                SAUCE.id -> SAUCE
                DESSERT.id -> DESSERT
                else -> throw IllegalArgumentException("No such category id: $categoryId")
            }
        }

    }

    override fun toString(): String = name.toLowerCase()

}
