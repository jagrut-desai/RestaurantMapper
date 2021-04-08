package com.example.restaurantmapper

import com.example.restaurantmapper.data.restaurant.RestaurantRemoteDataSource
import com.example.restaurantmapper.data.restaurant.RestaurantRepository
import com.example.restaurantmapper.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNetworkService(): NetworkService{
        return NetworkService()
    }

    @Singleton
    @Provides
    fun provideRestaurantRepository(): RestaurantRepository {
        return RestaurantRepository(provideRestaurantRemoteDataSource())
    }

    @Singleton
    @Provides
    fun provideRestaurantRemoteDataSource(): RestaurantRemoteDataSource{
        return RestaurantRemoteDataSource(provideNetworkService())
    }

}