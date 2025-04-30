package com.pdmtaller2.ErickGomez_00300723.ui.screens.restaurants

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
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

    Column {
        Text("FoodSpot")
        LazyColumn {
            items(categoriesWithRestaurants.size) { index ->
                val category = categoriesWithRestaurants.keys.elementAt(index)
                val restaurants = categoriesWithRestaurants[category] ?: emptyList()

                Text(text = "Categoría: $category")
                LazyRow {
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

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
//    MainScreen()
}