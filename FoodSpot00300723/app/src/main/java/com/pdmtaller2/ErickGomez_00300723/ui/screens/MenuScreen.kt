package com.pdmtaller2.ErickGomez_00300723.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.data.dummy.restaurants
import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant
import com.pdmtaller2.ErickGomez_00300723.ui.layout.AppSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(restaurantId: Int, navController: NavHostController) {
    val context = LocalContext.current

    val scrollState = rememberScrollState()
    var dishQuery = remember { mutableStateOf("") }
    val restaurant: Restaurant? = restaurants.firstOrNull { it.id == restaurantId }

    if (restaurant == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Restaurante no encontrado", style = MaterialTheme.typography.titleLarge)
        }
        return
    }

    val menu = if (dishQuery.value == "") {
        restaurant.menu
    }  else {
        restaurant.menu.filter { dish ->
            dish.name.contains(dishQuery.value, ignoreCase = true)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TopAppBar(
            title = {
                AppSearchBar(query = dishQuery)
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Search",
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Text(restaurant.name)
        Text(restaurant.description)

        Column {
            Text("Dishes")

            menu.forEach { dish ->
                Text(dish.name)
                Text(dish.description)
                Text(dish.imageUrl)

                Button(onClick = {
                    Toast.makeText(context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT)
                        .show()
                }) {
                    Text("Add to Cart")
                }
            }
        }
    }
}