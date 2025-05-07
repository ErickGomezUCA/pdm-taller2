package com.ebgh00300723.lab05.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ebgh00300723.lab05.ui.components.ProximitySensor

@Composable
fun SensorsPage(navController: NavHostController) {
    Scaffold(Modifier.fillMaxSize(), { Text(text = "Sensors") }
    ) { paddingValues ->
        Column {
            Button(onClick = {navController.popBackStack()}) {
                Text(text="Go back to home")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            ProximitySensor()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SensorsPagePreview() {
//    SensorsPage()
}