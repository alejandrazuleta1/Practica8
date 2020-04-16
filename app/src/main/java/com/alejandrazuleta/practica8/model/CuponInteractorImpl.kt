package com.alejandrazuleta.practica8.model

import com.alejandrazuleta.practica8.presenter.CuponPresenter

class CuponInteractorImpl (var cuponPresenter: CuponPresenter) : CuponInteractor {
    private var cuponRepository: CuponRepository = CuponRepositoryImpl(cuponPresenter)
    override fun loadListCupones() {
        cuponRepository.loadListCupones()
    }
}