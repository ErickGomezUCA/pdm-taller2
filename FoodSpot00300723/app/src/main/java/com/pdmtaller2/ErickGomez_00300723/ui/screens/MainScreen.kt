package com.pdmtaller2.ErickGomez_00300723.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.data.Restaurant
import com.pdmtaller2.ErickGomez_00300723.ui.components.RestaurantCard
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MenuRoute

val restaurants: List<Restaurant> = listOf(
    Restaurant(
        id = 1,
        name = "Restaurant 1",
        description = "Description 1",
        imageUrl = "https://example.com/image1.jpg",
        categories = listOf("Pizzas", "Comida italiana", "Vegetariano"),
        menu = listOf()
    ),
    Restaurant(
        id = 2,
        name = "Restaurant 2",
        description = "Description 2",
        imageUrl = "https://example.com/image2.jpg",
        categories = listOf("Pizzas", "Comida italiana", "Vegetariano"),
        menu = listOf()
    )
)

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

        LazyRow {
            items(categoriesWithRestaurants.size) { index ->
                val category = categoriesWithRestaurants.keys.elementAt(index)
                val restaurants = categoriesWithRestaurants[category] ?: emptyList()

                Text(text = "Categoría: $category")
                restaurants.forEach { restaurant ->
                    RestaurantCard(
                        name = restaurant.name,
                    ) { navController.navigate(MenuRoute.route) }
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