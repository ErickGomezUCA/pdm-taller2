package com.pdmtaller2.ErickGomez_00300723.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RestaurantCard(
    name: String,
//    restaurantImageUrl: String,
    onClick: () -> Unit
) {
    Card(onClick = onClick) {
        Column {
            // Replace with actual image loading logic
//            Image(painter = rememberImagePainter(restaurantImageUrl), contentDescription = null)
            Text(text = name)

        }
    }
}