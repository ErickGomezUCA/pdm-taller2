package com.ebgh00300723.lab05.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Task (
    val title: String,
    val description: String = "",
    val date: String = "",
    var completed: MutableState<Boolean> = mutableStateOf(false)
)