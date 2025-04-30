package com.pdmtaller2.ErickGomez_00300723.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant
import com.pdmtaller2.ErickGomez_00300723.ui.components.DishCard
import com.pdmtaller2.ErickGomez_00300723.ui.layout.AppSearchBar
import com.pdmtaller2.ErickGomez_00300723.ui.screens.restaurants.RestaurantsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(restaurantId: Int, navController: NavHostController, viewModel: RestaurantsViewModel = viewModel()) {
    val restaurants = viewModel.restaurant.collectAsState()
    val loading = viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRestaurants()
    }

    if (loading.value) {
        CircularProgressIndicator()
        return
    }

    val context = LocalContext.current
    val scrollState = rememberScrollState()
//    Remove states
    val dishQuery = remember { mutableStateOf("") }
    val restaurant: Restaurant? = restaurants.value.firstOrNull { it.id == restaurantId }

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

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
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

        Text(text = restaurant.name, fontWeight = FontWeight.Bold, fontSize = 24.sp, textAlign = TextAlign.Center)
        Text(text = restaurant.description, textAlign = TextAlign.Center)

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Menu", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(bottom = 16.dp), textAlign = TextAlign.Center)

            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                menu.forEach { dish ->
                    DishCard(
                        dish = dish,
                        onClickCart = {
                            Toast.makeText(context, "Clicked on ${dish.name}", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}