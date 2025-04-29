package com.pdmtaller2.ErickGomez_00300723.ui.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MainRoute
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MyOrdersRoute
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.SearchRoute

data class NavItem(val label: String, val icon: ImageVector, val route: String)

@Composable
fun AppBottomBar(navController: NavHostController) {
    val navItems = listOf(
        NavItem("Restaurantes", Icons.Filled.Home, MainRoute.route),
        NavItem("Buscar", Icons.Filled.Favorite, SearchRoute.route),
        NavItem("Mis Ordenes", Icons.Filled.ShoppingCart, MyOrdersRoute.route)
    )

    var selectedItem by rememberSaveable { mutableStateOf<String>(MainRoute.route) }

    NavigationBar {
        navItems.forEach { item ->
            NavigationBarItem(
                label = { Text(item.label) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                selected = selectedItem == item.route,
                onClick = {
                    selectedItem = item.route
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}