package com.freed_asd.fuel_calculator.presentation.statistic.trips

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor

class TripStatsViewModel(
    private val distanceInteractor: DistanceInteractor,
    private val priceInteractor: PriceInteractor
): BaseViewModel<Repository, Unit>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Unit>) {
        liveData.observe(owner, observer)
    }

    
}