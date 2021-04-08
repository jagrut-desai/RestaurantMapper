package com.example.restaurantmapper

import android.app.Application
import com.example.restaurantmapper.data.restaurant.RestaurantRepository
import com.example.restaurantmapper.data.restaurant.RestaurantResponse
import com.example.restaurantmapper.data.restaurant.Store
import com.example.restaurantmapper.searchlist.SearchViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModelTest: RobolectricTest(){
    lateinit var viewModel: SearchViewModel

    @MockK
    lateinit var repository: RestaurantRepository

    @MockK
    lateinit var application: Application

    @MockK
    lateinit var response: RestaurantResponse

    @MockK
    lateinit var call: Call<RestaurantResponse>

    @MockK
    lateinit var store: Store

    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = SearchViewModel(repository, application)
    }

    @Test
    fun `test fetchRestaurantDetail`(){
        val callback = slot<Callback<RestaurantResponse>>()
        every { repository.getRestaurants(any(),any(), capture(callback)) } just Runs
        every { response.stores } returns listOf()
        viewModel.fetchRestaurants()
        callback.captured.onResponse(call, Response.success(response))
        assertEquals(viewModel.storeList.value, mutableListOf<Store>())

    }

    @Test
    fun `test onClickRestaurant`(){
        viewModel.onClickRestaurant(store)
        assertEquals(viewModel.navToDetail.value!!.peekContent(), store)
    }
}