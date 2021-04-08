package com.example.restaurantmapper.data.restaurant

data class MerchantPromotion(
    val category_new_store_customers_only: Boolean,
    val daypart_constraints: List<Any>,
    val delivery_fee: Int,
    val delivery_fee_monetary_fields: DeliveryFeeMonetaryFields,
    val id: Int,
    val minimum_subtotal: Int,
    val minimum_subtotal_monetary_fields: MinimumSubtotalMonetaryFields
)