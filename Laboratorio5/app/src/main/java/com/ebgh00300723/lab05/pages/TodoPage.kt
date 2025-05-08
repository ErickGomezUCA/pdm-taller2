package com.ebgh00300723.lab05.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ebgh00300723.lab05.ui.theme.Laboratorio3Theme
import com.ebgh00300723.lab05.viewmodel.GeneralViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoPage(
    openDialog: MutableState<Boolean>,
    navController: NavHostController,
    viewModel: GeneralViewModel,
    modifier: Modifier = Modifier
) {
    val tasks = viewModel.tasks.collectAsState()

    Column {
        Button(onClick = { navController.popBackStack() }) { Text(text = "Go back to home") }
    }

    if (openDialog.value) {
        AddTaskDialog(
            openDialog = openDialog,
            tasks = tasks.value,
            viewModel = viewModel
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary
            ), title = { Text("My Tasks") })
        Column(modifier = Modifier.padding(16.dp)) {
            TaskList(
                tasks = tasks.value,
                viewModel = viewModel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoPagePreview() {
    Laboratorio3Theme {
//        TodoPage()
    }
}