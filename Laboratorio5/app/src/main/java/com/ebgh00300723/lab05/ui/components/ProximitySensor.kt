package com.ebgh00300723.lab05.ui.components

import android.hardware.Sensor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ebgh00300723.lab05.hooks.useSensor

@Composable
fun ProximitySensor () {
    val proximityValues = useSensor(Sensor.TYPE_PROXIMITY)

    Scaffold { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sensor de Proximidad", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Distancia: ${proximityValues[0]} cm", fontSize = 18.sp)
        }
    }
}