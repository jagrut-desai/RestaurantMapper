package com.example.restaurantmapper.data.restaurant

import java.text.DecimalFormat

data class Store(
    val average_rating: Double,
    val business_id: Int,
    val cover_img_url: String?,
    val delivery_fee: Int,
    val delivery_fee_monetary_fields: DeliveryFeeMonetaryFields,
    val description: String,
    val display_delivery_fee: String,
    val distance_from_consumer: Double,
    val extra_sos_delivery_fee: Int,
    val extra_sos_delivery_fee_monetary_fields: ExtraSosDeliveryFeeMonetaryFields,
    val header_img_url: String?,
    val id: Int,
    val is_consumer_subscription_eligible: Boolean,
    val is_newly_added: Boolean,
    val location: Location,
    val menus: List<Menu>,
    val merchant_promotions: List<MerchantPromotion>,
    val name: String,
    val next_close_time: String,
    val next_open_time: String,
    val num_ratings: Int,
    val price_range: Int,
    val promotion_delivery_fee: Int,
    val service_rate: Any,
    val status: Status,
    val url: String
){
    fun getShortDescription(): String{
        val splits = description.split(", ")
        return when {
            splits.isEmpty() -> ""
            splits.size == 1 -> splits[0]
            else -> splits[0] + ", " + splits[1]
        }
    }

    fun getDistanceWithTwoDecimalPoint(): String {
        val format = DecimalFormat("#.##")
        val formattedDistance = format.format(distance_from_consumer)
        return formattedDistance
    }

    fun getImageUrl(): String {
        return if(header_img_url != null && header_img_url.isNotEmpty()) {
            header_img_url
        } else if(cover_img_url != null && cover_img_url.isNotEmpty()){
            cover_img_url
        } else {
            " "
        }
    }
}

