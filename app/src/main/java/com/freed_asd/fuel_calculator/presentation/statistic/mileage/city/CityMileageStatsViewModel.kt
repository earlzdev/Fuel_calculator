package com.freed_asd.fuel_calculator.presentation.statistic.mileage.city

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor

class CityMileageStatsViewModel : BaseViewModel<ConsInteractor, Unit>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Unit>) {
        liveData.observe(owner, observer)
    }

    private fun allDbValues() {

    }
}