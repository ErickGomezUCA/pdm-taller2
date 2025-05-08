package com.ebgh00300723.lab05.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ebgh00300723.lab05.models.Task
import com.ebgh00300723.lab05.viewmodel.GeneralViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskDialog(
    openDialog: MutableState<Boolean>,
    tasks: MutableList<Task>,
    viewModel: GeneralViewModel,
    modifier: Modifier = Modifier
) {
    val taskTitle = remember { mutableStateOf<String>("") }
    val taskDescription = remember { mutableStateOf<String>("") }
    val taskDate = remember { mutableStateOf<String>("") }

    val showDatePicker = remember { mutableStateOf<Boolean>(false) }
    val dateState = rememberDatePickerState()

    if (showDatePicker.value) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker.value = false },
            confirmButton = {
                Button(onClick = {
//                    Convert selected date from milliseconds into a formatted date as string
                    showDatePicker.value = false
                    val selectedDateInMillis: Long? = dateState.selectedDateMillis

                    if (selectedDateInMillis != null) {
                        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                        formatter.timeZone = TimeZone.getTimeZone("UTC")
                        val formattedValue = formatter.format(Date(selectedDateInMillis))

                        taskDate.value = formattedValue
                    } else {
                        taskDate.value = ""
                    }
                }) { Text("Select") }
            }
        ) {
            DatePicker(state = dateState)
        }
    }
    Dialog(
        onDismissRequest = {
            openDialog.value = false
        },
    ) {
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = taskTitle.value,
                onValueChange = { taskTitle.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                label = { Text(text = "Title") },
            )
            TextField(
                value = taskDescription.value,
                onValueChange = { taskDescription.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                label = { Text(text = "Description (optional)") },
            )
            //    TODO: Set value to selected date
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                value = taskDate.value,
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { showDatePicker.value = true }) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Calendar icon"
                        )
                    }
                },
                onValueChange = {},
                label = { Text(text = "Select a date (optional)") }
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = { openDialog.value = false },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) { Text(text = "Cancel") }
                Button(
                    onClick = {
//                        tasks.add(Task(taskTitle.value, taskDescription.value, taskDate.value))
                        viewModel.addTask(Task(taskTitle.value, taskDescription.value, taskDate.value))
                        openDialog.value = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    enabled = (taskTitle.value != "")
                ) {
                    Text(text = "Create")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AddTaskDialogPreview() {
//    AddTaskDialog(
//        openDialog = remember { mutableStateOf<Boolean>(true) },
//        tasks = remember { mutableStateListOf<Task>() }),
//}