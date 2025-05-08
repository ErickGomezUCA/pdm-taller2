package com.ebgh00300723.lab05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ebgh00300723.lab05.navigation.HomeRoute
import com.ebgh00300723.lab05.navigation.SensorsRoute
import com.ebgh00300723.lab05.navigation.TodoRoute
import com.ebgh00300723.lab05.pages.HomePage
import com.ebgh00300723.lab05.pages.SensorsPage
import com.ebgh00300723.lab05.ui.composables.AddTaskButton
import com.ebgh00300723.lab05.ui.composables.TodoPage
import com.ebgh00300723.lab05.ui.theme.Laboratorio3Theme
import com.ebgh00300723.lab05.viewmodel.GeneralViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio3Theme {
                val navController = rememberNavController()
                val viewModel: GeneralViewModel = viewModel()

                NavHost(navController = navController, startDestination = HomeRoute) {
                    composable<HomeRoute> {
                        HomePage(
                            onNavigateToGreeting = { navController.navigate(TodoRoute) },
                            onNavigateToSensors = { navController.navigate(SensorsRoute) }
                        )
                    }

                    composable<TodoRoute> {
                        val openDialog = remember { mutableStateOf(false) }

                        Scaffold(
                            floatingActionButton = { AddTaskButton(openDialog) },
                            floatingActionButtonPosition = FabPosition.End,
                            modifier = Modifier
                                .fillMaxSize(),
                        ) { innerPadding ->
                            TodoPage(openDialog = openDialog, navController = navController, viewModel = viewModel, modifier = Modifier.padding(innerPadding))
                        }
                    }
                    composable<SensorsRoute> {
                        SensorsPage(navController = navController)
                    }
                }

            }
        }
    }
}