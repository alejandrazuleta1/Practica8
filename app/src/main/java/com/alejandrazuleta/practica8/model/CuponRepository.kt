package com.alejandrazuleta.practica8.model

import androidx.lifecycle.MutableLiveData

interface CuponRepository {
    fun callOffersAPI()
    fun getOffers() : MutableLiveData<List<Offer>>
}