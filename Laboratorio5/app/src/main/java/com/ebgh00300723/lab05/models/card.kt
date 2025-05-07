package com.ebgh00300723.lab05.models

import java.util.Date

data class Card(
    val pos: Int = 0,
    val title: String,
    val description: String,
    val endDate: Date = Date(),
    val checked: Boolean = false,

    val onDelete: (Int) -> Unit = {},
) {
    fun toggleChecked() = copy(checked = !checked)
}