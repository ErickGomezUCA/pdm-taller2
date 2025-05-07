package com.ebgh00300723.lab05

import TodoPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ebgh00300723.lab05.navigation.HomeRoute
import com.ebgh00300723.lab05.navigation.SensorsRoute
import com.ebgh00300723.lab05.navigation.TodoRoute
import com.ebgh00300723.lab05.pages.HomePage
import com.ebgh00300723.lab05.pages.SensorsPage
import com.ebgh00300723.lab05.ui.theme.Laboratorio3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio3Theme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = HomeRoute) {
                    composable<HomeRoute> {
                        HomePage(
                            onNavigateToGreeting = { navController.navigate(TodoRoute) },
                            onNavigateToSensors = { navController.navigate(SensorsRoute) }
                        )
                    }

                    composable<TodoRoute> {
                        TodoPage(navController = navController)
                    }
                    composable<SensorsRoute> {
                        SensorsPage(navController = navController)
                    }
                }

            }
        }
    }
}