package com.pdmtaller2.ErickGomez_00300723.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.pdmtaller2.ErickGomez_00300723.data.model.Dish

@Composable
fun DishCard(
    dish: Dish,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card {
        Column(modifier = Modifier.fillMaxWidth()){
            Text(dish.name)
            Text(dish.description)
            AsyncImage(
                model = dish.imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            Button(onClick = onClick) {
                Text("Add to Cart")
            }
        }
    }
}