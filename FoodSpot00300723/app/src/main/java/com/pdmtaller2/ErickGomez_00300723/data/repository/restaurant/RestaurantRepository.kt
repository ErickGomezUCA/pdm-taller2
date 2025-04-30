package com.pdmtaller2.ErickGomez_00300723.data.repository.restaurant

import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurants(): List<Restaurant>
}