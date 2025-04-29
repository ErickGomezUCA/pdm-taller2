package com.pdmtaller2.ErickGomez_00300723.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.pdmtaller2.ErickGomez_00300723.ui.layout.AppSearchBar

@Composable
fun SearchScreen() {
    val searchQuery = remember { mutableStateOf("") }


    Column (modifier = Modifier.fillMaxSize()) {
        AppSearchBar(searchQuery)
    }
}