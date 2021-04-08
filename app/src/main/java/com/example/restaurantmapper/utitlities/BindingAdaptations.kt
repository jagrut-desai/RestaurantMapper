package com.example.restaurantmapper.utitlities

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.example.restaurantmapper.R
import com.squareup.picasso.Picasso

object BindingAdaptations {

    @JvmStatic
    @BindingAdapter("image_url")
    fun loadImageIntoImageView(imageView: AppCompatImageView, url: String?){
        if(url == null || url.isEmpty() ){
            imageView.setImageResource(R.drawable.ic_launcher_background)
        } else {
            Picasso.get().load(url).placeholder(R.drawable.ic_launcher_background).fit().into(imageView)
        }
    }
}