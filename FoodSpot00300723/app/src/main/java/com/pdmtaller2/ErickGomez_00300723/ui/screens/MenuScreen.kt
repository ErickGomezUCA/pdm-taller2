package com.pdmtaller2.ErickGomez_00300723.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pdmtaller2.ErickGomez_00300723.ui.data.Dish

@Composable
fun MenuScreen(restaurantTitle: String, restaurantDescription: String, dishes: List<Dish>) {
    Column {
        Text(restaurantTitle)
        Text(restaurantDescription)
    }
    Column {
        Text("Dishes")
    }

}