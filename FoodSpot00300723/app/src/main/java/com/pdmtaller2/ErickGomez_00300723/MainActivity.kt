package com.pdmtaller2.ErickGomez_00300723

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdmtaller2.ErickGomez_00300723.ui.layout.MainScaffold
import com.pdmtaller2.ErickGomez_00300723.ui.theme.FoodSpotByEgomezTheme

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
