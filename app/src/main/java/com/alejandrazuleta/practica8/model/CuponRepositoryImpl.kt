package com.alejandrazuleta.practica8.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alejandrazuleta.practica8.model.server.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuponRepositoryImpl(): CuponRepository{

    private var offers = MutableLiveData<List<Offer>>()

    override fun callOffersAPI() {
        //val apiKey="16ab4d84f2da9b70874015feedce8e69"
        val apiKey="beabfcd2f9cf74f624230f27f377b5d1"
        val format="json"
        var offerslist: ArrayList<Offer>?= ArrayList()

        ApiService.create()
            .getDeals(apiKey,format)
            .enqueue(object : Callback<Cupones> {
                override fun onFailure(call: Call<Cupones>, t: Throwable) {
                    Log.d("Error",t?.message)
                    //cuponPresenter.showErrorLoadDeals(t.message)
                }

                override fun onResponse(call: Call<Cupones>, response: Response<Cupones>) {
                    if (response.isSuccessful){
                      offerslist = response.body()?.offers as ArrayList<Offer>
                    }
                    offers.value = offerslist
                }
            })
    }

    override fun getOffers():MutableLiveData<List<Offer>> {
        return offers
    }

}