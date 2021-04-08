package com.example.restaurantmapper.data.restaurant

data class MenuX(
    val id: Int,
    val is_business_enabled: Any,
    val is_catering: Boolean,
    val menu_version: Int,
    val name: String,
    val open_hours: List<List<OpenHour>>,
    val status: String,
    val status_type: String,
    val subtitle: String
)