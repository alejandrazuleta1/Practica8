package com.alejandrazuleta.practica8.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alejandrazuleta.practica8.model.Offer
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class DetailViewModel : ViewModel(){

    private var offer: MutableLiveData<Offer> = MutableLiveData()

    fun setDetailOffer(offer: Offer){
        this.offer.value = offer
    }

    fun getOffer() = offer

    companion object{
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImageDetail(imageView: ImageView,imageUrl:String?){
            if(!imageUrl.isNullOrEmpty()) Glide.with(imageView.context).load(imageUrl).into(imageView)
                //Picasso.get().load("https://image.tmdb.org/t/p/w500" + imageUrl).into(imageView)
        }
    }
}