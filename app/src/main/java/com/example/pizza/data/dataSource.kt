package com.example.pizza.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.pizza.R

data class Pizza(
    val name: String,
    @DrawableRes val imageId: Int,
    @StringRes val ingredients: Int,
    @StringRes val description: Int,
    val size: Int,
    val price: Int
)



val pizzaList = listOf<Pizza>(
    Pizza("Маргарита", R.drawable.margarita_pic, R.string.margarita_ingredients, R.string.margarita_des, 35, 420),
    Pizza("Пепперони", R.drawable.pepperoni_pic, R.string.pepperoni_ingredients, R.string.pepperoni_des, 35, 299),
    Pizza("Гавайская", R.drawable.hawaiskay_pic, R.string.hawaiskay_ingredients, R.string.hawaiskay_des, 35, 299),
    Pizza("Четыре Сыра", R.drawable.four_chesses_pic, R.string.four_cheeses_ingredients, R.string.four_cheeses_des, 35, 539),
    Pizza("Вегетарианская", R.drawable.vegeterian_pic, R.string.vegeterian_ingredients, R.string.vegeterian_des, 35, 539),
    Pizza("Мексиканская", R.drawable.mexican_pic, R.string.mexican_ingredients, R.string.mexican_des, 35, 539),
    Pizza("Морепродукты", R.drawable.seafood_pic, R.string.seafoods_ingredients, R.string.seafoods_dess, 35, 539),
    Pizza("Барбекю-цыпленок", R.drawable.barbecy_chicken_pic, R.string.barbeky_chicken_ingredients, R.string.barbeky_des, 35, 539),
    Pizza("Грибная", R.drawable.mushroom_pic, R.string.mushroom_ingredients, R.string.mushroom_des, 35, 539),
    Pizza("Детройтская", R.drawable.detroit_pic, R.string.detroit_ingredients, R.string.detroit_des, 35, 539),
    Pizza("Тосканская", R.drawable.toskanian_pic, R.string.toskanian_ingredients, R.string.toskanian_des, 35, 539),
    Pizza("Карбонара", R.drawable.carbonara_pic, R.string.carbonara_ingredients, R.string.carbonara_des, 35, 539),
    Pizza("Средиземноморсая", R.drawable.medeterenian_pic, R.string.medeterenian_ingredients, R.string.medeterenian_des, 35, 539),
    Pizza("Бруссельская", R.drawable.bruselsay_pic, R.string.brusselckay_ingredients, R.string.brusselckay_des, 35, 539),
    Pizza("Индийская", R.drawable.indian_pic, R.string.indian_ingredients, R.string.indian_des, 35, 539)
)