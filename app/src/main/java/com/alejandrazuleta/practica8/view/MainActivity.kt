package com.alejandrazuleta.practica8.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.practica8.R
import com.alejandrazuleta.practica8.databinding.ActivityMainBinding
import com.alejandrazuleta.practica8.model.Offer
import com.alejandrazuleta.practica8.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private var mainViewModel:MainViewModel ? =null

    private var listCupones = ArrayList<Offer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBindings(savedInstanceState)
    }

    private fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        activityMainBinding.model = mainViewModel

        setupListUpdate()
    }

    private fun setupListUpdate() {
        mainViewModel?.callOffers()

        mainViewModel?.getOffers()?.observe(this, Observer {
            Log.d("Offer",it.get(0).title)
            mainViewModel?.setOffersInCuponesAdapder(it)
        })

        setupListClick()
    }

    private fun setupListClick() {
        mainViewModel?.getOfferSelected()?.observe(this, Observer { offer->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("offer", offer)
            startActivity(intent)
        })
    }

}

