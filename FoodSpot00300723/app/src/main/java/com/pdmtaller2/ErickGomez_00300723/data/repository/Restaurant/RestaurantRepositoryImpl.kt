package com.pdmtaller2.ErickGomez_00300723.data.repository.Restaurant

import com.pdmtaller2.ErickGomez_00300723.data.dummy.restaurants
import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant
import kotlinx.coroutines.delay

class RestaurantRepositoryImpl: RestaurantRepository {
    override suspend fun getRestaurants(): List<Restaurant> {
        delay(5000)
        return restaurants
    }
}