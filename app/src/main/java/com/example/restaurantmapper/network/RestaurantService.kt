package com.example.restaurantmapper.network

import com.example.restaurantmapper.data.restaurant.RestaurantDetail
import com.example.restaurantmapper.data.restaurant.RestaurantResponse
import com.example.restaurantmapper.data.restaurant.Store
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantService {

    @GET("v1/store_feed/")
    fun getStoreFeed(
        @Query("lat") latitude: Double,
        @Query("lng") longitude: Double,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 50
    ): Call<RestaurantResponse>


    @GET("v2/restaurant/{restaurant_id}")
    fun getStoreDetails(@Path("restaurant_id") id: Int): Call<RestaurantDetail>

}