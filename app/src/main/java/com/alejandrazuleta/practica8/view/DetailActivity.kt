package com.alejandrazuleta.practica8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alejandrazuleta.practica8.R
import com.alejandrazuleta.practica8.model.Offer
import com.alejandrazuleta.practica8.viewmodel.DetailViewModel
import com.alejandrazuleta.practica8.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity() {

    private var detailViewModel: DetailViewModel?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupBinding(savedInstanceState)
    }

    fun setupBinding(savedInstanceState: Bundle?) {
        var activityDetailBinding : ActivityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail)

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        activityDetailBinding.lifecycleOwner = this

        detailViewModel?.setDetailOffer(intent?.getSerializableExtra("offer") as Offer)
    }
}
