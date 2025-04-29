package com.pdmtaller2.ErickGomez_00300723.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.ErickGomez_00300723.data.model.Dish
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
                startDestination = MainRoute
            ) {
                composable<MainRoute> {
                    MainScreen(navController = navController)
                }

                composable<MenuRoute> { backStackEntry ->
                    val id = backStackEntry.arguments?.getInt("restaurantId") ?: 0

                    MenuScreen(navController = navController, restaurantId = id)
                }

                composable <SearchRoute> {
                    SearchScreen(navController = navController)
                }

                composable <MyOrdersRoute> {
                    MyOrdersScreen()
                }
            }

        }
    }
}