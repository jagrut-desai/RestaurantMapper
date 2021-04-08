package com.example.restaurantmapper.data.restaurant

data class RestaurantDetail(
    val address: Address,
    val asap_time: Int,
    val average_rating: Double,
    val business: Business,
    val business_id: Int,
    val composite_score: Int,
    val cover_img_url: String?,
    val delivery_fee: Int,
    val delivery_fee_details: DeliveryFeeDetails,
    val delivery_radius: Int,
    val description: String,
    val extra_sos_delivery_fee: Int,
    val fulfills_own_deliveries: Boolean,
    val header_image_url: String?,
    val id: Int,
    val inflation_rate: Double,
    val is_consumer_subscription_eligible: Boolean,
    val is_good_for_group_orders: Boolean,
    val is_newly_added: Boolean,
    val is_only_catering: Boolean,
    val max_composite_score: Int,
    val max_order_size: Any,
    val menus: List<MenuX>,
    val merchant_promotions: List<MerchantPromotionX>,
    val name: String,
    val number_of_ratings: Int,
    val object_type: String,
    val offers_delivery: Boolean,
    val offers_pickup: Boolean,
    val phone_number: String,
    val price_range: Int,
    val provides_external_courier_tracking: Boolean,
    val service_rate: Double,
    val should_show_store_logo: Boolean,
    val show_store_menu_header_photo: Boolean,
    val show_suggested_items: Boolean,
    val slug: String,
    val special_instructions_max_length: Int,
    val status: String,
    val status_type: String,
    val tags: List<String>,
    val yelp_biz_id: String,
    val yelp_rating: Double,
    val yelp_review_count: Int
) {
    fun getImageUrl(): String {
        return if(header_image_url != null && header_image_url.isNotEmpty()) {
            header_image_url
        } else if(cover_img_url != null && cover_img_url.isNotEmpty()){
            cover_img_url
        } else {
            " "
        }
    }
}