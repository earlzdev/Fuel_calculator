package com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.freed_asd.fuel_calculator.databinding.FragmentDistanceItemDesignBinding
import com.freed_asd.fuel_calculator.databinding.FragmentPriceItemDesignBinding

class StatsRvAdapter(private val itemList: ArrayList<RecyclerTripItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            PRICE_VIEW -> {
                val view = FragmentPriceItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PriceItemViewHolder(view)
            }
            DISTANCE_VIEW -> {
                val view = FragmentDistanceItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DistanceItemViewHolder((view))
            }
            else -> throw IllegalStateException("No such view type :_(")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            PRICE_VIEW -> {
                (holder as PriceItemViewHolder).bind(itemList[position])
            }
            DISTANCE_VIEW -> {
                (holder as DistanceItemViewHolder).bind(itemList[position])
            }
        }
    }

    override fun getItemCount() = itemList.size

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position].type) {
            ItemType.PRICE -> PRICE_VIEW
            ItemType.DISTANCE -> DISTANCE_VIEW
        }
    }


    inner class DistanceItemViewHolder(private val distanceView: FragmentDistanceItemDesignBinding)
        : RecyclerView.ViewHolder(distanceView.root) {

            fun bind(item: RecyclerTripItem) {
                distanceView.distanceName.text = item.name
                distanceView.distanceInfo.text = item.type.toString()
                distanceView.distanceImage.setImageResource(item.image)
            }
        }

    inner class PriceItemViewHolder(private val priceView: FragmentPriceItemDesignBinding)
        : RecyclerView.ViewHolder(priceView.root) {

            fun bind(item: RecyclerTripItem) {
                priceView.priceName.text = item.name
                priceView.priceInfo.text = item.type.toString()
                priceView.priceImage.setImageResource(item.image)
            }
        }

    companion object {

        const val PRICE_VIEW = 0
        const val DISTANCE_VIEW = 1
    }
}