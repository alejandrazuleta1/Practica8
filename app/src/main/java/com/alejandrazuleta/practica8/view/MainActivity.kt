package com.alejandrazuleta.practica8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.practica8.R
import com.alejandrazuleta.practica8.model.Offer
import com.alejandrazuleta.practica8.presenter.CuponPresenter
import com.alejandrazuleta.practica8.presenter.CuponPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CuponView{

    private var cuponPresenter: CuponPresenter ?= null

    private var listCupones = ArrayList<Offer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cuponPresenter = CuponPresenterImpl(this)
        getCupones()
    }

    private fun getCupones() {
        cuponPresenter?.loadListCupones()
    }

    override fun showErrorLoadDeals(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun showListOffers(offers: List<Offer>?) {
        this.listCupones = offers as ArrayList<Offer>
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )
        val cuponesAdapter = CuponesAdapter(listCupones)
        recyclerView.adapter = cuponesAdapter
    }

    override fun showProgresBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgresBar() {
        progressBar.visibility = View.GONE
    }


}

