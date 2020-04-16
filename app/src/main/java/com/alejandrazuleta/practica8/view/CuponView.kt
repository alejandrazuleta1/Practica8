package com.alejandrazuleta.practica8.view

import com.alejandrazuleta.practica8.model.Offer

interface CuponView {
    fun showErrorLoadDeals(message: String?)
    fun showListOffers(offers: List<Offer>?)
    fun showProgresBar()
    fun hideProgresBar()
}