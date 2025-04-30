package com.pdmtaller2.ErickGomez_00300723.ui.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MainRoute
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MyOrdersRoute
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.SearchRoute

data class NavItem(val label: String, val icon: ImageVector, val route: Any)

@Composable
fun AppBottomBar(navController: NavHostController) {
    val navItems = listOf(
        NavItem("Restaurantes", Icons.Filled.Home, MainRoute),
        NavItem("Buscar", Icons.Filled.Search, SearchRoute),
        NavItem("Mis Órdenes", Icons.Filled.ShoppingCart, MyOrdersRoute)
    )

    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                label = { Text(item.label) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}