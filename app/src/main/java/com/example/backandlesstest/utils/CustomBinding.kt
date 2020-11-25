package com.example.backandlesstest.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.backandlesstest.R
import com.squareup.picasso.Picasso

@BindingAdapter("loadingImage")
fun bindingImage(image: ImageView, imageUrl: String) {
    Picasso.get()
        .load(imageUrl)
        .placeholder(R.mipmap.ic_loading)
        .resize(300,300)
        .into(image)
}