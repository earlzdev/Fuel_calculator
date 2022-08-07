package com.freedasd.fuel_calculator.presentation.distance.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freedasd.fuel_calculator.core.BaseViewModel
import com.freedasd.fuel_calculator.core.Event
import com.freedasd.fuel_calculator.data.Repository
import com.freedasd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freedasd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freedasd.fuel_calculator.presentation.distance.DistanceInputUi
import com.freedasd.fuel_calculator.presentation.distance.DistanceResultUi
import com.freedasd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper

class DistanceViewModel(
    private val distanceInteractor: DistanceInteractor,
    private val inputMapper: BaseInputUiToDomainMapper,
    private val resultMapper: BaseResultDomainToUiMapper
): BaseViewModel<Repository, Event<DistanceResultUi>>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<DistanceResultUi>>) {
        liveData.observe(owner, observer)
    }

    fun calculate(input: DistanceInputUi.Base) : DistanceResultUi {
        val result = distanceInteractor.calcMaxDistance(input.map(inputMapper)).map(resultMapper)
        liveData.value = Event(result)
        return result
    }
}