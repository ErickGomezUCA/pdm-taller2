package com.pdmtaller2.ErickGomez_00300723.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pdmtaller2.ErickGomez_00300723.ui.data.Restaurant

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
fun MainScreen() {
    // Group restaurants by categories
    val categoriesWithRestaurants = restaurants
        .flatMap { restaurant ->
            restaurant.categories.map { category -> category to restaurant }
        }
        .groupBy({ it.first }, { it.second })

    Column {
        Text(text = "Restaurantes por Categorías")

        // Display each category and its restaurants
        categoriesWithRestaurants.forEach { (category, restaurants) ->
            Text(text = "Categoría: $category")
//            TODO: Navigate between restaurants
            restaurants.forEach { restaurant ->
                Text(text = "- ${restaurant.name}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}