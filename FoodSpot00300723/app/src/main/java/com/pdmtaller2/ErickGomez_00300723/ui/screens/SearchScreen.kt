package com.pdmtaller2.ErickGomez_00300723.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.data.dummy.restaurants
import com.pdmtaller2.ErickGomez_00300723.data.model.Dish
import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant
import com.pdmtaller2.ErickGomez_00300723.ui.layout.AppSearchBar
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MenuRoute

data class SearchResult(
    val dish: Dish,
    val restaurant: Restaurant
)

fun searchDishes(query: String): List<SearchResult> {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    val searchQuery = remember { mutableStateOf("") }
    val result: List<SearchResult> = if (searchQuery.value == "") {
        emptyList()
    } else {
        searchDishes(searchQuery.value)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { AppSearchBar(searchQuery) },
            modifier = Modifier.fillMaxWidth()
        )

        if (result == emptyList<SearchResult>()) {
            Text(text = "Sus resultados aparecerán aquí")
        } else {
            result.forEach { res ->
                Card(onClick = { navController.navigate(MenuRoute(restaurantId = res.restaurant.id)) }) {
                    Column {
                        Text(res.restaurant.name)
                        Text(res.dish.name)
//                        TODO: Properly show categories
                        Text(res.restaurant.categories.toString())
                    }
                }
            }
        }
    }
}