package com.example.restaurantmapper.searchlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantmapper.R
import com.example.restaurantmapper.data.restaurant.Store
import com.example.restaurantmapper.databinding.RestaurantListItemBinding
import com.squareup.picasso.Picasso

class SearchAdapter(val viewModel: SearchViewModel) : ListAdapter<Store, SearchAdapter.RestaurantViewHolder>(DIFF_ITEMS) {

    companion object{
        val DIFF_ITEMS = object : DiffUtil.ItemCallback<Store>(){
            override fun areItemsTheSame(oldItem: Store, newItem: Store): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Store, newItem: Store): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantViewHolder {
        val binding = RestaurantListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.viewModel = viewModel
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class RestaurantViewHolder(val binding: RestaurantListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val restaurantLogo = binding.restaurantLogo
        fun onBind(store: Store){
            binding.restaurant = store
        }
    }
}