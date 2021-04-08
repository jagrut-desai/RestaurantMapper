package com.example.restaurantmapper.searchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantmapper.R
import com.example.restaurantmapper.data.Constants
import com.example.restaurantmapper.data.restaurant.Store
import com.example.restaurantmapper.databinding.FragmentSearchBinding
import com.example.restaurantmapper.detail.RestaurantDetailFragment
import com.example.restaurantmapper.utitlities.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: Fragment() {

    private val viewModel: SearchViewModel by viewModels()
    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.storeList.adapter = SearchAdapter(viewModel)
        binding.storeList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        setUpEvents()
    }

    private fun setUpEvents(){
        viewModel.storeList.observe(this.viewLifecycleOwner, Observer {
            initStoreList(it)
        })

        viewModel.navToDetail.observe(this.viewLifecycleOwner,  EventObserver {
            navigateToDetailFragment(it)
        })
    }

    private fun navigateToDetailFragment(it: Store) {
        this.parentFragmentManager.commit {
            addToBackStack(this.javaClass.simpleName)
            val bundle = Bundle()
            bundle.putInt(Constants.RESTAURANT_ID, it.id)
            replace<RestaurantDetailFragment>(R.id.fragment_container, this.javaClass.simpleName, bundle)
        }
    }

    private fun initStoreList(storeList: List<Store>) {
        (binding.storeList.adapter as SearchAdapter).submitList(storeList)
    }
}