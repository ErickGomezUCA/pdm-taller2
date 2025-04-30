package com.pdmtaller2.ErickGomez_00300723.ui.screens.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant
import com.pdmtaller2.ErickGomez_00300723.data.repository.restaurant.RestaurantRepository
import com.pdmtaller2.ErickGomez_00300723.data.repository.restaurant.RestaurantRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestaurantsViewModel: ViewModel() {
    val restaurantsRepository: RestaurantRepository = RestaurantRepositoryImpl()

    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurant: StateFlow<List<Restaurant>> = _restaurants

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading: StateFlow<Boolean> = _loading

    fun loadRestaurants() {
        viewModelScope.launch {
            _loading.value = true
            _restaurants.value = restaurantsRepository.getRestaurants()
            _loading.value = false
        }
    }
}