package com.pdmtaller2.ErickGomez_00300723

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.ErickGomez_00300723.data.Dish
import com.pdmtaller2.ErickGomez_00300723.ui.layout.MainScaffold
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MainRoute
import com.pdmtaller2.ErickGomez_00300723.ui.navigation.MenuRoute
import com.pdmtaller2.ErickGomez_00300723.ui.theme.FoodSpotByEgomezTheme
import com.pdmtaller2.ErickGomez_00300723.ui.screens.MainScreen
import com.pdmtaller2.ErickGomez_00300723.ui.screens.MenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByEgomezTheme {
                MainScaffold()
            }
        }
    }
}
