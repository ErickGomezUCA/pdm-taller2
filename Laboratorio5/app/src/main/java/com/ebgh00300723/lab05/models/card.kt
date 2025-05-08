package com.ebgh00300723.lab05.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import java.util.Date

data class Card(
    val pos: Int = 0,
    val title: String,
    val description: String,
    val endDate: Date = Date(),
    val checked: MutableState<Boolean> = mutableStateOf(false),

    val onDelete: (Int) -> Unit = {},
) {

}