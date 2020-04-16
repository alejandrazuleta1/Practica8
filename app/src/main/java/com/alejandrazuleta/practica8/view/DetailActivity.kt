package com.alejandrazuleta.practica8.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.alejandrazuleta.practica8.R
import com.alejandrazuleta.practica8.model.Offer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val offer = intent?.getSerializableExtra("offer") as Offer
        supportActionBar!!.title = offer.title
        updateUI(offer)
    }

    private fun updateUI(offer: Offer) {
        tv_title.text = offer.title
        tv_description.text = offer.description
        tv_categories.text = offer.categories
        tv_endDate.text = offer.endDate
        tv_url.text = offer.url
        if(offer.imageUrl.isNotEmpty()) Glide.with(this).load(offer.imageUrl).into(imageView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
