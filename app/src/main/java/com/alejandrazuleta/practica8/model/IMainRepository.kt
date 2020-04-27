package com.alejandrazuleta.practica8.model

import androidx.lifecycle.MutableLiveData

interface IMainRepository {
    fun callOffersAPI()
    fun getOffers(): MutableLiveData<List<Offer>>
}