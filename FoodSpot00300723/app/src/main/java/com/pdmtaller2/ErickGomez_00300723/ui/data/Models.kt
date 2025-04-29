package com.pdmtaller2.ErickGomez_00300723.ui.data

data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
)

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val categories: List<String>,
    val menu: List<Dish>,
)
