package com.pdmtaller2.ErickGomez_00300723.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.pdmtaller2.ErickGomez_00300723.data.model.Dish

@Composable
fun DishCard(
    dish: Dish,
    onClick: () -> Unit = {},
    onClickCart: () -> Unit = {},
    includeDescription: Boolean = true,
    includeButton: Boolean = true,
    modifier: Modifier = Modifier
) {
    Card(onClick = onClick) {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = dish.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = dish.name, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                if (includeDescription) Text(text = dish.description)


                if (includeButton) Button(onClick = onClickCart, modifier = Modifier.fillMaxWidth()) {
                    Text("Agregar al carrito")
                }
            }
        }
    }
}