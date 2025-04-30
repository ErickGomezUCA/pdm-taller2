package com.pdmtaller2.ErickGomez_00300723.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.data.model.SearchResult
import com.pdmtaller2.ErickGomez_00300723.helpers.searchDishes
import com.pdmtaller2.ErickGomez_00300723.ui.layout.AppSearchBar
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MenuRoute
import com.pdmtaller2.ErickGomez_00300723.ui.screens.restaurants.RestaurantsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController, viewModel: RestaurantsViewModel = viewModel()) {
    val restaurants = viewModel.restaurant.collectAsState()
    val loading = viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRestaurants()
    }

    if (loading.value) {
        CircularProgressIndicator()
        return
    }

    val searchQuery = remember { mutableStateOf("") }
    val result: List<SearchResult> = if (searchQuery.value == "") {
        emptyList()
    } else {
        searchDishes(searchQuery.value, restaurants.value)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { AppSearchBar(searchQuery) },
            modifier = Modifier.fillMaxWidth()
        )

        if (result == emptyList<SearchResult>()) {
            Text(text = "Sus resultados aparecerán aquí")
        } else {
            result.forEach { res ->
                Card(onClick = { navController.navigate(MenuRoute(restaurantId = res.restaurant.id)) }) {
                    Column {
                        Text(res.restaurant.name)
                        Text(res.dish.name)
//                        TODO: Properly show categories
                        Text(res.restaurant.categories.toString())
                    }
                }
            }
        }
    }
}