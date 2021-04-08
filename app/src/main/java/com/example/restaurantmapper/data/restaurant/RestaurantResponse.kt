package com.example.restaurantmapper.data.restaurant

data class RestaurantResponse(
    val is_first_time_user: Boolean,
    val next_offset: Int,
    val num_results: Int,
    val show_list_as_pickup: Boolean,
    val sort_order: String,
    val stores: List<Store>
)