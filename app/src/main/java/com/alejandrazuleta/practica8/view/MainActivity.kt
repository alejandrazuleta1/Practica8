package com.alejandrazuleta.practica8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.practica8.R
import com.alejandrazuleta.practica8.model.ApiService
import com.alejandrazuleta.practica8.model.Cupones
import com.alejandrazuleta.practica8.model.Offer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var listCupones = ArrayList<Offer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        )

        loadList()
    }

    private fun loadList() {
        val apiKey="16ab4d84f2da9b70874015feedce8e69"
        val format="json"

        ApiService.create()
                .getDeals(apiKey,format)
                .enqueue(object : Callback<Cupones> {
                    override fun onFailure(call: Call<Cupones>, t: Throwable) {
                        Log.d("Error",t?.message)
                    }

                    override fun onResponse(call: Call<Cupones>, response: Response<Cupones>) {
                        if (response.isSuccessful){
                            listCupones = response.body()?.offers as ArrayList<Offer>
                            Log.d("verificacion","entré")
                            val cuponesAdapter =
                                CuponesAdapter(
                                    listCupones
                                )
                            recyclerView.adapter = cuponesAdapter
                        }
                    }
                })

    }

}

