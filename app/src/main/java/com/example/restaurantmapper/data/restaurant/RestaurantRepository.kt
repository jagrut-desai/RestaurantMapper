package com.example.restaurantmapper.data.restaurant

import retrofit2.Callback
import javax.inject.Inject


class RestaurantRepository @Inject constructor(private val restaurantRemoteDataSource: RestaurantRemoteDataSource) {

    fun getRestaurants(latitude: Double, longitude: Double, callback: Callback<RestaurantResponse>){
        restaurantRemoteDataSource.getRestaurants(latitude, longitude, callback)
    }

    fun getRestaurant(id: Int, callback: Callback<RestaurantDetail>){
        restaurantRemoteDataSource.getRestaurant(id, callback)
    }
}