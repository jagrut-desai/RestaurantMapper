package com.example.restaurantmapper.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantmapper.data.restaurant.RestaurantDetail
import com.example.restaurantmapper.data.restaurant.RestaurantRepository
import com.example.restaurantmapper.data.restaurant.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val repository: RestaurantRepository, application: Application): AndroidViewModel(application) {

    private val _restaurantDetail = MutableLiveData<RestaurantDetail>()
    val restaurantDetail : LiveData<RestaurantDetail> = _restaurantDetail

    fun fetchRestaurantDetail(id: Int) {
        repository.getRestaurant(id, object : Callback<RestaurantDetail>{
            override fun onResponse(call: Call<RestaurantDetail>, response: Response<RestaurantDetail>) {
                _restaurantDetail.value = response.body()
            }

            override fun onFailure(call: Call<RestaurantDetail>, t: Throwable) {
            }

        })
    }
}