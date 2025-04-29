package com.pdmtaller2.ErickGomez_00300723.data.dummy

import com.pdmtaller2.ErickGomez_00300723.data.model.Dish
import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant

val restaurants: List<Restaurant> = listOf(
    Restaurant(
        id = 1,
        name = "Restaurant 1",
        description = "Description 1",
        imageUrl = "https://example.com/image1.jpg",
        categories = listOf("Pizzas", "Comida italiana", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Dish 1",
                description = "Description 1",
                imageUrl = "https://example.com/dish1.jpg"
            ),
            Dish(
                id = 2,
                name = "Dish 2",
                description = "Description 2",
                imageUrl = "https://example.com/dish2.jpg"
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Restaurant 2",
        description = "Description 2",
        imageUrl = "https://example.com/image2.jpg",
        categories = listOf("Pizzas", "Comida italiana", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 3,
                name = "Dish 3",
                description = "Description 3",
                imageUrl = "https://example.com/dish3.jpg"
            ),
            Dish(
                id = 4,
                name = "Dish 4",
                description = "Description 4",
                imageUrl = "https://example.com/dish4.jpg"
            )
        )
    )
)
