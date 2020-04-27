package com.alejandrazuleta.practica8.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alejandrazuleta.practica8.model.Offer
import com.bumptech.glide.Glide

class DetailViewModel: ViewModel() {
    private var offer : MutableLiveData<Offer> = MutableLiveData()

    fun setDetailOffer(offer: Offer){
        this.offer.value = offer
    }

    fun getOffer() = offer

    companion object{
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImageDetail(imageView: ImageView, imageUrl: String?){
            if(imageUrl?.isNotEmpty()!!) Glide.with(imageView.context).load(imageUrl).into(imageView)
        }
    }
}