package com.alejandrazuleta.practica8.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alejandrazuleta.practica8.model.MainObservable
import com.alejandrazuleta.practica8.model.Offer
import com.alejandrazuleta.practica8.view.CuponesAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class MainViewModel: ViewModel() {
    private var mainObservable: MainObservable = MainObservable()
    private var cuponesAdapter: CuponesAdapter ?= null
    private var offerSelected : MutableLiveData<Offer> = MutableLiveData()

    fun callOffers(){
        mainObservable.callOffers()
    }

    fun getOffers() : MutableLiveData<List<Offer>> {
        return mainObservable.getOffers()
    }

    fun setOffersInOffersAdapter(offers: List<Offer>){
        cuponesAdapter?.setOffersList(offers)
        cuponesAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCuponesAdapter(): CuponesAdapter? {
        cuponesAdapter = CuponesAdapter(this)
        return cuponesAdapter
    }

    fun getOfferAt(position: Int): Offer?{
        var offer: List<Offer>?=mainObservable.getOffers().value
        return offer?.get(position)
    }

    fun onItemClick(position: Int){
        val offer = getOfferAt(position)
        offerSelected.value = offer
    }

    fun getOfferSelected() : MutableLiveData<Offer>{
        return offerSelected
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageUrl:String?){
            if (!imageUrl.isNullOrEmpty()) Glide.with(imageView.context).load(imageUrl).into(imageView)
                //Picasso.get().load("https://image.tmdb.org/t/p/w500" + imageUrl).into(imageView)
        }
    }
}