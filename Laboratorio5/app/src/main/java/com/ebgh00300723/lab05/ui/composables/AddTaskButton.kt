package com.ebgh00300723.lab05.ui.composables

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddTaskButton(openDialog: MutableState<Boolean>, modifier: Modifier = Modifier) {

    FloatingActionButton(
        onClick = { openDialog.value = !openDialog.value },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add task")
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun AddTaskButtonPreview() {
    AddTaskButton(mutableStateOf(false))
}