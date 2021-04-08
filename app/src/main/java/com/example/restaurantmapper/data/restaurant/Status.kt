package com.example.restaurantmapper.data.restaurant

data class Status(
    val asap_available: Boolean,
    val asap_minutes_range: List<Int>,
    val pickup_available: Boolean,
    val scheduled_available: Boolean,
    val unavailable_reason: Any
) {
    fun getASAPMinutes(): String {
        return if(asap_available && !asap_minutes_range.isNullOrEmpty()){
            asap_minutes_range[0].toString() + " Mins"
        } else {
            "Closed"
        }
    }
}