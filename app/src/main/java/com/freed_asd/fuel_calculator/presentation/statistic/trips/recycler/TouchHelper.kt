package com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.RecyclerView
import com.freed_asd.fuel_calculator.presentation.statistic.trips.TripsStatsViewModel

class TouchHelper(
    private val adapter: StatsRvAdapter,
    private val action: SwipeAction
) : ItemTouchHelper.SimpleCallback(0, RIGHT or LEFT) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val item = adapter.currentList[viewHolder.adapterPosition]
        action.removeItem(item.id())
    }
}

interface SwipeAction {
    fun removeItem(item: Long)
}