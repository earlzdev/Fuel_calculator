package com.freed_asd.fuel_calculator.presentation.statistic.trips

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.ItemType
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.RecyclerTripItem

class TripsStatsViewModel(
    private val distanceInteractor: DistanceInteractor,
    private val priceInteractor: PriceInteractor
): BaseViewModel<Repository, Unit>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Unit>) {
        liveData.observe(owner, observer)
    }

    fun testRecyclerItems() : ArrayList<RecyclerTripItem> =
        arrayListOf(
            RecyclerTripItem(0, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE),
            RecyclerTripItem(1, "Name", "Info", R.drawable.ic_test3, ItemType.PRICE),
            RecyclerTripItem(2, "Name", "Info", R.drawable.ic_test3, ItemType.PRICE),
            RecyclerTripItem(3, "Name", "Info", R.drawable.ic_test3, ItemType.PRICE),
            RecyclerTripItem(4, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE),
            RecyclerTripItem(5, "Name", "Info", R.drawable.ic_test3, ItemType.PRICE),
            RecyclerTripItem(6, "Name", "Info", R.drawable.ic_test3, ItemType.PRICE),
            RecyclerTripItem(7, "Name", "Info", R.drawable.ic_test3, ItemType.PRICE),
            RecyclerTripItem(8, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE),
            RecyclerTripItem(9, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE),
            RecyclerTripItem(10, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE),
            RecyclerTripItem(11, "Name", "Info", R.drawable.ic_test3, ItemType.PRICE),
            RecyclerTripItem(12, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE),
            RecyclerTripItem(13, "Name", "Info", R.drawable.ic_test3, ItemType.PRICE),
            RecyclerTripItem(14, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE),
            RecyclerTripItem(15, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE),
            RecyclerTripItem(16, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE),
            RecyclerTripItem(17, "Name", "Info", R.drawable.ic_test3, ItemType.DISTANCE)
        )
    }
