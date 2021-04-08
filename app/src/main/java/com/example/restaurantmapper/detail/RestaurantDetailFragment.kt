package com.example.restaurantmapper.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.restaurantmapper.data.Constants
import com.example.restaurantmapper.databinding.FragmentDetailBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantDetailFragment : Fragment() {

    val viewModel: DetailViewModel by viewModels()
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt(Constants.RESTAURANT_ID)
        if(id != null) {
            viewModel.fetchRestaurantDetail(id)
        } else {
            Snackbar.make(view, "Oops! Something went wrong", Snackbar.LENGTH_LONG)
        }
        setUpEvents()
    }

    private fun setUpEvents() {
        viewModel.restaurantDetail.observe(this.viewLifecycleOwner, Observer {
            binding.restaurant = it
        })
    }
}