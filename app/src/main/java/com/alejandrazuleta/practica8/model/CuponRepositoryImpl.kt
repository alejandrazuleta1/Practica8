package com.alejandrazuleta.practica8.model

import android.util.Log
import com.alejandrazuleta.practica8.presenter.CuponPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuponRepositoryImpl(var cuponPresenter: CuponPresenter): CuponRepository{
    override fun loadListCupones() {
        //val apiKey="16ab4d84f2da9b70874015feedce8e69"
        val apiKey="beabfcd2f9cf74f624230f27f377b5d1"
        val format="json"

        ApiService.create()
            .getDeals(apiKey,format)
            .enqueue(object : Callback<Cupones> {
                override fun onFailure(call: Call<Cupones>, t: Throwable) {
                    Log.d("Error",t?.message)
                    cuponPresenter.showErrorLoadDeals(t.message)
                }

                override fun onResponse(call: Call<Cupones>, response: Response<Cupones>) {
                    if (response.isSuccessful){
                        cuponPresenter.sendListOffers(response.body()?.offers)
                    }
                }
            })
    }

}