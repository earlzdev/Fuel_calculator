package com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.freed_asd.fuel_calculator.R

class Adapter {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName = view.findViewById<TextView>(R.id.item_text)
    }
}