package com.pdmtaller2.ErickGomez_00300723.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.data.dummy.restaurants
import com.pdmtaller2.ErickGomez_00300723.data.model.Dish
import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant
import com.pdmtaller2.ErickGomez_00300723.ui.components.RestaurantCard
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MenuRoute

@Composable
fun MainScreen(navController: NavHostController) {
    // Group restaurants by categories
    val categoriesWithRestaurants = restaurants
        .flatMap { restaurant ->
            restaurant.categories.map { category -> category to restaurant }
        }
        .groupBy({ it.first }, { it.second })

    Column {
        Text("FoodSpot")
        LazyColumn {
            items(categoriesWithRestaurants.size) { index ->
                val category = categoriesWithRestaurants.keys.elementAt(index)
                val restaurants = categoriesWithRestaurants[category] ?: emptyList()

                Text(text = "Categoría: $category")
                LazyRow {
                    items(restaurants.size) { restaurantIndex ->
                        val restaurant = restaurants[restaurantIndex]
                        RestaurantCard(
                            name = restaurant.name,
                            onClick = {
                                navController.navigate(MenuRoute(restaurantId = restaurant.id))
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
//    MainScreen()
}