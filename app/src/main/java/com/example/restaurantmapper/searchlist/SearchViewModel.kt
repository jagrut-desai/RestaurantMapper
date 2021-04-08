package com.example.restaurantmapper.searchlist

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.restaurantmapper.data.restaurant.RestaurantRepository
import com.example.restaurantmapper.data.restaurant.RestaurantResponse
import com.example.restaurantmapper.data.restaurant.Store
import com.example.restaurantmapper.utitlities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: RestaurantRepository, application: Application) : AndroidViewModel(application) {

    private val _storeList = MutableLiveData<MutableList<Store>>()
    val storeList : LiveData<MutableList<Store>> = _storeList

    private val _navToDetail = MutableLiveData<Event<Store>>()
    val navToDetail: LiveData<Event<Store>> = _navToDetail

    init {
        fetchRestaurants()
    }

    fun fetchRestaurants(){
        repository.getRestaurants(37.422740, -122.139956, object : Callback<RestaurantResponse> {
            override fun onResponse(
                call: Call<RestaurantResponse>,
                response: Response<RestaurantResponse>
            ) {
                _storeList.value = response.body()?.stores?.toMutableList()
            }

            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
            }

        })
    }

    fun onClickRestaurant(store:Store){
        _navToDetail.value = Event(store)
    }

}