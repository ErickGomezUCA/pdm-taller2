package com.pdmtaller2.ErickGomez_00300723.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.data.model.SearchResult
import com.pdmtaller2.ErickGomez_00300723.helpers.searchDishes
import com.pdmtaller2.ErickGomez_00300723.ui.components.DishCard
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
    val searchResult: List<SearchResult> = if (searchQuery.value == "") {
        emptyList()
    } else {
        searchDishes(searchQuery.value, restaurants.value)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        TopAppBar(
            title = { AppSearchBar(searchQuery) },
            modifier = Modifier.fillMaxWidth()
        )

        if (searchResult == emptyList<SearchResult>()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Sus resultados aparecerán aquí",
                    color = Color(0xFF494949),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(searchResult) { result ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = result.restaurant.name,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        LazyRow {
                            items(result.restaurant.categories) { category ->
                                Card(
                                    modifier = Modifier.padding(end = 8.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(
                                            0xFF8BCEBE
                                        )
                                    )
                                ) {
                                    Text(
                                        text = category,
                                        modifier = Modifier.padding(8.dp),
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            result.dishes.forEach { dish ->
                                DishCard(
                                    dish = dish,
                                    onClick = {
                                        navController.navigate(MenuRoute(restaurantId = result.restaurant.id))
                                    },
                                    includeDescription = false,
                                    includeButton = false,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}