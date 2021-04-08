package com.example.restaurantmapper.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    fun getRestaurantService(): RestaurantService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.doordash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RestaurantService::class.java)
    }

}