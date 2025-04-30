package com.pdmtaller2.ErickGomez_00300723.helpers

import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant

fun getCategoriesWithRestaurants(restaurants: List<Restaurant>): Map<String, List<Restaurant>> {
    return restaurants
        .flatMap { restaurant ->
            restaurant.categories.map { category -> category to restaurant }
        }
        .groupBy({ it.first }, { it.second })
}