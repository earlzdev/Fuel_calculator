package com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.freed_asd.fuel_calculator.databinding.FragmentPriceItemDesignBinding
import com.freed_asd.fuel_calculator.presentation.price.dbItem.PriceDbItemUi

interface ItemClickListener {

    fun onItemDetails(item: PriceDbItemUi)
}

class StatsRvAdapter(
    private val clickListener: ItemClickListener
) : ListAdapter<PriceDbItemUi, PriceItemViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentPriceItemDesignBinding.inflate(inflater, parent, false)
        return PriceItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PriceItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener.onItemDetails(item)
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<PriceDbItemUi>() {

     override fun areItemsTheSame(oldItem: PriceDbItemUi, newItem: PriceDbItemUi) =
         oldItem.id() == newItem.id()

     override fun areContentsTheSame(oldItem: PriceDbItemUi, newItem: PriceDbItemUi) =
         oldItem.name() == newItem.name()
    }
}

class PriceItemViewHolder(private val binding: FragmentPriceItemDesignBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PriceDbItemUi) {
        binding.priceName.text = item.name()
    }
}