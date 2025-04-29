package com.pdmtaller2.ErickGomez_00300723.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.ErickGomez_00300723.data.Dish
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MainRoute
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MenuRoute
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MyOrdersRoute
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.SearchRoute
import com.pdmtaller2.ErickGomez_00300723.ui.screens.MainScreen
import com.pdmtaller2.ErickGomez_00300723.ui.screens.MenuScreen
import com.pdmtaller2.ErickGomez_00300723.ui.screens.MyOrdersScreen
import com.pdmtaller2.ErickGomez_00300723.ui.screens.SearchScreen

@Composable
fun MainScaffold() {
    val selectedItem = remember { mutableStateOf(0) }
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = { AppBottomBar(navController = navController) }) { innerPadding ->


        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            NavHost(
                navController = navController,
                startDestination = MainRoute.route
            ) {
                composable(MainRoute.route) {
                    MainScreen(navController = navController)
                }

                composable(MenuRoute.route) {
                    MenuScreen(
                        restaurantTitle = "Example",
                        restaurantDescription = "Example Description",
                        dishes = listOf(
                            Dish(
                                id = 1,
                                name = "Dish 1",
                                description = "Description 1",
                                imageUrl = "https://example.com/dish1.jpg"
                            ),
                            Dish(
                                id = 2,
                                name = "Dish 2",
                                description = "Description 2",
                                imageUrl = "https://example.com/dish2.jpg"
                            )
                        )
                    )
                }

                composable (SearchRoute.route) {
                    SearchScreen()
                }

                composable (MyOrdersRoute.route) {
                    MyOrdersScreen()
                }
            }

        }
    }
}