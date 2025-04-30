package com.pdmtaller2.ErickGomez_00300723.helpers

import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant
import com.pdmtaller2.ErickGomez_00300723.data.model.SearchResult

fun searchDishes(query: String, restaurants: List<Restaurant>): List<SearchResult> {
    val lowerCaseQuery = query.lowercase()

    return restaurants.flatMap { restaurant ->
        val matchesRestaurantName = restaurant.name.contains(lowerCaseQuery, ignoreCase = true)
        val matchesCategory =
            restaurant.categories.any { it.contains(lowerCaseQuery, ignoreCase = true) }

        restaurant.menu.filter { dish ->
            matchesRestaurantName ||
                    matchesCategory ||
                    dish.name.contains(lowerCaseQuery, ignoreCase = true)
        }.map { dish ->
            SearchResult(
                dish = dish,
                restaurant = restaurant
            )
        }
    }
}
