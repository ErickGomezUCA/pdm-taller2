package com.pdmtaller2.ErickGomez_00300723.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainRoute

@Serializable
data class MenuRoute(val restaurantId: Int)

@Serializable
object SearchRoute

@Serializable
object MyOrdersRoute