package com.freed_asd.fuel_calculator.presentation.distance.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.DistanceInteractor
import com.freed_asd.fuel_calculator.presentation.core.BaseViewModel
import com.freed_asd.fuel_calculator.presentation.core.Event
import com.freed_asd.fuel_calculator.presentation.distance.DistanceInputUi
import com.freed_asd.fuel_calculator.presentation.distance.DistanceResultUi
import com.freed_asd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper

class DistanceViewModel(
    private val distanceInteractor: DistanceInteractor,
    private val inputMapper: BaseInputUiToDomainMapper,
    private val resultMapper: BaseResultDomainToUiMapper
): BaseViewModel<Event<DistanceResultUi>>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<DistanceResultUi>>) {
        liveData.observe(owner, observer)
    }

    fun calculate(input: DistanceInputUi.Base) : DistanceResultUi {
        val result = distanceInteractor.calcMaxDistance(input.map(inputMapper)).map(resultMapper)
        liveData.value = Event(result)
        return result
    }
}