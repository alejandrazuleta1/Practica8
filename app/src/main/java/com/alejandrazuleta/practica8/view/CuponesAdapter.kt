package com.alejandrazuleta.practica8.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.practica8.BR
import com.alejandrazuleta.practica8.R
import com.alejandrazuleta.practica8.model.Offer
import com.alejandrazuleta.practica8.viewmodel.MainViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cupon_list_item.view.*

class CuponesAdapter(var mainViewModel: MainViewModel) :
    RecyclerView.Adapter<CuponesAdapter.CuponesViewHolder>() {

    private var cuponesList : List<Offer>?= null

    fun setOffersList(offers: List<Offer>){
        this.cuponesList = offers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponesViewHolder {
        val layoutInflater:LayoutInflater= LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType,parent,false)
        return CuponesViewHolder(binding)
    }

    override fun getItemCount(): Int = cuponesList?.size?: 0

    override fun onBindViewHolder(holder: CuponesViewHolder, position: Int) {
        holder.setOffer(mainViewModel,position)
    }

    class CuponesViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
    {

        private var binding: ViewDataBinding ? = null

        init {
            this.binding = binding
        }

        fun setOffer(mainViewModel: MainViewModel,position: Int) {
            binding?.setVariable(BR.model,mainViewModel)
            binding?.setVariable(BR.position,position)
            binding?.executePendingBindings()
        }


    }
}