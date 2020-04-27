package com.alejandrazuleta.practica8.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class MainObservable : BaseObservable() {
    private var mainRepository : IMainRepository = MainRepository()

    fun callOffers(){
        mainRepository.callOffersAPI()
    }

    fun getOffers(): MutableLiveData<List<Offer>>{
        return mainRepository.getOffers()
    }

}