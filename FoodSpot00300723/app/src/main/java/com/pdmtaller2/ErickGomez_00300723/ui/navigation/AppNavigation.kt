package com.pdmtaller2.ErickGomez_00300723.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pdmtaller2.ErickGomez_00300723.ui.screens.Restaurants.MainScreen
import com.pdmtaller2.ErickGomez_00300723.ui.screens.MenuScreen
import com.pdmtaller2.ErickGomez_00300723.ui.screens.MyOrdersScreen
import com.pdmtaller2.ErickGomez_00300723.ui.screens.SearchScreen

@Composable
fun AppNavigation(navController: NavHostController) {
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