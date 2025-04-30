package com.pdmtaller2.ErickGomez_00300723.ui.screens.restaurants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.helpers.getCategoriesWithRestaurants
import com.pdmtaller2.ErickGomez_00300723.ui.components.RestaurantCard
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MenuRoute

@Composable
fun MainScreen(navController: NavHostController, viewModel: RestaurantsViewModel = viewModel()) {
    val restaurants = viewModel.restaurant.collectAsState()
    val loading = viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRestaurants()
    }

    if (loading.value) {
        CircularProgressIndicator()
        return
    }

    // Group restaurants by categories
    val categoriesWithRestaurants = getCategoriesWithRestaurants(restaurants.value)

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "FoodSpot", fontSize = 28.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 24.dp, bottom = 8.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            items(categoriesWithRestaurants.size) { index ->
                val category = categoriesWithRestaurants.keys.elementAt(index)
                val restaurants = categoriesWithRestaurants[category] ?: emptyList()

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = category, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(restaurants.size) { restaurantIndex ->
                            val restaurant = restaurants[restaurantIndex]
                            RestaurantCard(
                                restaurant = restaurant,
                                onClick = {
                                    navController.navigate(MenuRoute(restaurantId = restaurant.id))
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
//    MainScreen()
}