package com.ebgh00300723.lab05.viewmodel

import androidx.lifecycle.ViewModel
import com.ebgh00300723.lab05.models.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GeneralViewModel: ViewModel() {
    private val _tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
    val tasks = _tasks.asStateFlow()

    fun addTask(task: Task) {
        _tasks.value = _tasks.value.toMutableList().apply { add(task) }
    }

    fun deleteTask(task: Task) {
        _tasks.value = _tasks.value.toMutableList().apply { remove(task) }
    }

    fun moveTask(from: Int, to: Int) {
        val tasksList = _tasks.value.toMutableList()
        if (from in tasksList.indices && to in tasksList.indices) {
            val task = tasksList.removeAt(from)
            tasksList.add(to, task)
            _tasks.value = tasksList
        }
    }


    fun changePriority(task: Task, positions: Int) {
        val tasksList = _tasks.value.toMutableList()

        val currentIndex: Int = tasksList.indexOf(task);
//    Task is not in list
        if (currentIndex == -1)
            return

        var newPosition: Int = currentIndex + positions;

        if (newPosition < 0) {
//      Unsafe result (lower), setting newPosition to first element of the list
            newPosition = 0
        }
        else if (newPosition > tasksList.size - 1) {
//      Unsafe result (upper), setting newPosition to last possible element of the list
            newPosition = tasksList.size - 1
        }

//    Do not move element when current and new position are the same
        if (currentIndex == newPosition)
            return

//    Move element successfully
        tasksList.remove(task)
        tasksList.add(newPosition, task)
    }
}