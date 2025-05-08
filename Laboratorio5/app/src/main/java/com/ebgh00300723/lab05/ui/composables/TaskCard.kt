package com.ebgh00300723.lab05.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ebgh00300723.lab05.models.Task
import com.ebgh00300723.lab05.ui.theme.Black25
import com.ebgh00300723.lab05.ui.theme.LightBlue100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard(
    task: Task,
    onCompleteTask: (Boolean) -> Unit,
    onDeleteTask: () -> Unit,
    onChangePriority: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(if (task.completed.value) LightBlue100 else MaterialTheme.colorScheme.surface)
            .border(width = 1.dp, color = Black25, shape = RoundedCornerShape(8.dp))
            .padding(vertical = 20.dp, horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.completed.value,
            onCheckedChange = onCompleteTask,
            colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = task.title,
                color = MaterialTheme.colorScheme.onSurface,
                textDecoration = if (task.completed.value) TextDecoration.LineThrough else null
            )

            if (task.description != "")
                Text(
                    text = task.description,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 12.sp
                )

            if (task.date != "")
                Text(
                    text = task.date,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 12.sp
                )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                IconButton(onClick = { onChangePriority(-1) }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Move task priority up"
                    )
                }
                IconButton(onClick = { onChangePriority(1) }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Move task priority down"
                    )
                }
            }

            IconButton(onClick = onDeleteTask) {
                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = "Delete",
                    tint = Red
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCardPreview() {
    TaskCard(
        task = Task(
            title = "Task 1",
            description = "Description",
            date = "13/01/2003",
            completed = remember { mutableStateOf<Boolean>(true) }
        ), onCompleteTask = {}, onDeleteTask = {}, onChangePriority = {})
}