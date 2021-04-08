package com.example.restaurantmapper

import android.app.Application
import com.example.restaurantmapper.data.restaurant.RestaurantDetail
import com.example.restaurantmapper.data.restaurant.RestaurantRepository
import com.example.restaurantmapper.detail.DetailViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailViewModelTest: RobolectricTest(){

    lateinit var viewModel: DetailViewModel

    @MockK
    lateinit var repository: RestaurantRepository

    @MockK
    lateinit var application: Application

    @MockK
    lateinit var restaurantDetail: RestaurantDetail

    @MockK
    lateinit var call: Call<RestaurantDetail>

    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = DetailViewModel(repository, application)
    }


    @Test
    fun `test fetchRestaurantDetail`(){
        val callback = slot<Callback<RestaurantDetail>>()
        every { repository.getRestaurant(any(), capture(callback)) } just Runs
        viewModel.fetchRestaurantDetail(0)
        callback.captured.onResponse(call, Response.success(restaurantDetail))
        assertEquals(viewModel.restaurantDetail.value, restaurantDetail)

    }


}