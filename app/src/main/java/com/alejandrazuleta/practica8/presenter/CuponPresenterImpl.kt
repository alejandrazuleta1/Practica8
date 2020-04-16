package com.alejandrazuleta.practica8.presenter

import com.alejandrazuleta.practica8.model.CuponInteractor
import com.alejandrazuleta.practica8.model.CuponInteractorImpl
import com.alejandrazuleta.practica8.model.Offer
import com.alejandrazuleta.practica8.view.CuponView

class CuponPresenterImpl(var cuponView: CuponView) : CuponPresenter {
    private var cuponInteractor: CuponInteractor = CuponInteractorImpl(this)

    override fun loadListCupones() {
        cuponView.showProgresBar()
        cuponInteractor.loadListCupones()
    }

    override fun showErrorLoadDeals(message: String?) {
        cuponView.showErrorLoadDeals(message)
        cuponView.hideProgresBar()
    }

    override fun sendListOffers(offers: List<Offer>?) {
        cuponView.showListOffers(offers)
        cuponView.hideProgresBar()
    }
}