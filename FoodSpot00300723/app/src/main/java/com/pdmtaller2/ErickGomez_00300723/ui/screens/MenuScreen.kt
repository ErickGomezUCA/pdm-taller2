package com.pdmtaller2.ErickGomez_00300723.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pdmtaller2.ErickGomez_00300723.data.Dish

@Composable
fun MenuScreen(restaurantTitle: String, restaurantDescription: String, dishes: List<Dish>) {
    Column {
        Text(restaurantTitle)
        Text(restaurantDescription)
    }
    Column {
        Text("Dishes")

        dishes.forEach { dish ->
            Text(dish.name)
            Text(dish.description)
            Text(dish.imageUrl)

//            Show a Toast with "$dish.name agregado al carrito"
            Button (onClick = {}) {
                Text("Add to Cart")
            }
        }
    }

}