package com.ebgh00300723.lab05.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomePage(onNavigateToGreeting: () -> Unit, onNavigateToSensors: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { Text(text = "Home") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onNavigateToGreeting) {
                Text("Go to Todo Page")
            }
            Button(onClick = onNavigateToSensors) {
                Text("Go to Sensors Page")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
//    HomePage()
}