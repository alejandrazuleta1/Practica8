package com.alejandrazuleta.practica8.presenter

import com.alejandrazuleta.practica8.model.Offer

interface CuponPresenter {
    fun loadListCupones()
    fun showErrorLoadDeals(message: String?)
    fun sendListOffers(offers: List<Offer>?)
}