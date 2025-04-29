package com.pdmtaller2.ErickGomez_00300723.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pdmtaller2.ErickGomez_00300723.ui.data.Restaurant

data class Category(
    val name: String,
    val restaurants: List<Restaurant>
)

val categories: List<Category> = listOf(
    Category(
        name = "Comida rapida",
        restaurants = listOf(
            Restaurant(
                id = 1,
                name = "McDonald's",
                description = "Comida rapida",
                imageUrl = "https://example.com/mcdonalds.jpg",
                categories = listOf("Comida rapida"),
                menu = listOf()
            ),
            Restaurant(
                id = 2,
                name = "Burger King",
                description = "Comida rapida",
                imageUrl = "https://example.com/burgerking.jpg",
                categories = listOf("Comida rapida"),
                menu = listOf()
            )
        )
    ),
    Category(
        name = "Comida mexicana",
        restaurants = listOf(
            Restaurant(
                id = 3,
                name = "Taco Bell",
                description = "Comida mexicana",
                imageUrl = "https://example.com/tacobell.jpg",
                categories = listOf("Comida mexicana"),
                menu = listOf()
            ),
            Restaurant(
                id = 4,
                name = "Chipotle",
                description = "Comida mexicana",
                imageUrl = "https://example.com/chipotle.jpg",
                categories = listOf("Comida mexicana"),
                menu = listOf()
            )
        )
    ),
    Category(
        name = "Comida italiana",
        restaurants = listOf(
            Restaurant(
                id = 5,
                name = "Olive Garden",
                description = "Comida italiana",
                imageUrl = "https://example.com/olivegarden.jpg",
                categories = listOf("Comida italiana"),
                menu = listOf()
            ),
            Restaurant(
                id = 6,
                name = "Pizza Hut",
                description = "Comida italiana",
                imageUrl = "https://example.com/pizzahut.jpg",
                categories = listOf("Comida italiana"),
                menu = listOf()
            )
        )
    )
)

@Composable
fun MainScreen() {
    Column {
        Text(text= "Restaurantes por categorias")

        categories.forEach { category ->
            Text(text = category.name)
            category.restaurants.forEach { restaurant ->
//                TODO: Change this presentation into a card with text and image
                Button(onClick = { /* TODO: Navigate to restaurant details */ }) {
                    Text(text = restaurant.name)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}