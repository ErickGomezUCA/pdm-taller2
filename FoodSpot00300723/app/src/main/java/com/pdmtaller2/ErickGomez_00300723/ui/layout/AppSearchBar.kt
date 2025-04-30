package com.pdmtaller2.ErickGomez_00300723.ui.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchBar(query: MutableState<String>) {
    var dishQueryActive by remember {mutableStateOf(false)}

    SearchBar (
        query = query.value,
        active = dishQueryActive,
        onQueryChange = { query.value = it },
        onSearch = { dishQueryActive = false },
        onActiveChange = { dishQueryActive = it },
        placeholder = { Text("Busque un platillo aquí...") },
        leadingIcon = { Icon(imageVector =  Icons.Default.Search, contentDescription = "Search") },
        trailingIcon = {
            if (dishQueryActive) {
                Icon(
                    modifier = Modifier.clickable {
                        if (query.value.isNotEmpty()) {
                            query.value = ""
                        } else {
                            dishQueryActive = false
                        }
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Clear search",
                )

            }
        },
        modifier = Modifier.fillMaxWidth(),
    ) {

    }
}