package com.alejandrazuleta.practica8.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejandrazuleta.practica8.R
import com.alejandrazuleta.practica8.model.Offer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cupon_list_item.view.*

class CuponesAdapter(cuponesList: ArrayList<Offer>) :
    RecyclerView.Adapter<CuponesAdapter.CuponesViewHolder>() {

    private var cuponesList = ArrayList<Offer>()

    init {
        this.cuponesList = cuponesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cupon_list_item, parent, false)
        return CuponesViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = cuponesList.size

    override fun onBindViewHolder(holder: CuponesViewHolder, position: Int) {
        val offer = cuponesList[position]
        holder.setOffer(offer)
    }

    class CuponesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var offer: Offer? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setOffer(offer: Offer) {
            this.offer = offer
            itemView.tv_title.text = offer.title
            itemView.tv_store.text = offer.store
            itemView.tv_off.text = offer.offerValue
            if(offer.imageUrl.isNotEmpty()) Glide.with(itemView.context).load(offer.imageUrl).into(itemView.iv_picture)
        }

        override fun onClick(v: View) {
            /*
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("movie", movie)
            intent.putExtra("envia","list")
            itemView.context.startActivity(intent)

             */
        }


    }
}