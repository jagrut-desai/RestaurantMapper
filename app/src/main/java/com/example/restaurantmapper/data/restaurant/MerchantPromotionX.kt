package com.example.restaurantmapper.data.restaurant

data class MerchantPromotionX(
    val category_id: Int,
    val delivery_fee: Int,
    val description: String,
    val id: Int,
    val minimum_order_cart_subtotal: Int,
    val new_store_customers_only: Boolean,
    val sort_order: Int,
    val title: String
)