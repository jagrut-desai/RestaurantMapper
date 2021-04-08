package com.example.restaurantmapper.data.restaurant

import com.example.restaurantmapper.network.NetworkService
import retrofit2.Callback
import javax.inject.Inject

class RestaurantRemoteDataSource @Inject constructor(private val networkService: NetworkService) {


    fun getRestaurants(latitude: Double, longitude: Double, callback: Callback<RestaurantResponse>){
        val restaurantService = networkService.getRestaurantService()
        restaurantService.getStoreFeed(latitude, longitude).enqueue(callback)
    }

    fun getRestaurant(id: Int, callback: Callback<RestaurantDetail>){
        val restaurantService = networkService.getRestaurantService()
        restaurantService.getStoreDetails(id).enqueue(callback)
    }

}