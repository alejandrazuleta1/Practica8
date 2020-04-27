package com.alejandrazuleta.practica8.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class MainObservable : BaseObservable() {
    private var cuponRepository:CuponRepository = CuponRepositoryImpl()

    fun callOffers(){
        cuponRepository.callOffersAPI()
    }

    fun getOffers(): MutableLiveData<List<Offer>>{
        return cuponRepository.getOffers()
    }
}