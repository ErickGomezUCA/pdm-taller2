package com.ebgh00300723.lab05.ui.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ebgh00300723.lab05.models.Task
import com.ebgh00300723.lab05.ui.theme.Black05
import com.ebgh00300723.lab05.viewmodel.GeneralViewModel

fun deleteTask(task: Task, tasks: MutableList<Task>) {
    tasks.remove(task)
}

fun completeTask(task: Task) {
    task.completed.value = !task.completed.value
}

fun changePriority(task: Task, tasks: MutableList<Task>, positions: Int) {
    val currentIndex: Int = tasks.indexOf(task);
//    Task is not in list
    if (currentIndex == -1)
        return

    var newPosition: Int = currentIndex + positions;

    if (newPosition < 0) {
//      Unsafe result (lower), setting newPosition to first element of the list
        newPosition = 0
    }
    else if (newPosition > tasks.size - 1) {
//      Unsafe result (upper), setting newPosition to last possible element of the list
        newPosition = tasks.size - 1
    }

//    Do not move element when current and new position are the same
    if (currentIndex == newPosition)
        return

//    Move element successfully
    tasks.remove(task)
    tasks.add(newPosition, task)
}

@Composable
fun TaskList(tasks: MutableList<Task>, modifier: Modifier = Modifier, viewModel: GeneralViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        if (tasks.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "There are no tasks to show",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "You can start creating new tasks by pressing the plus button down below!",
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(16.dp))
                .background(color = Black05)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            tasks.forEach { task ->
                TaskCard(
                    task = task,
                    onCompleteTask = { completeTask(task) },
                    onDeleteTask = { viewModel.deleteTask(task) },
                    onChangePriority = { direction -> viewModel.changePriority(task, direction) },
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TaskListPreview() {
//    TaskList(tasks = remember {
//        mutableStateListOf<Task>(
//            Task(
//                title = "Task 1",
//                description = "Description of the task 1"
//            ),
//            Task(
//                title = "Task 2",
//                description = "Description of the task 2",
//                date = "13/01/2003"
//            ),
//            Task(
//                title = "Task 3"
//            )
//        )
//    })
//}