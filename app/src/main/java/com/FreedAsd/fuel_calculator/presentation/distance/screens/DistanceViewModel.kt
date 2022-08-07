package com.FreedAsd.fuel_calculator.presentation.distance.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.FreedAsd.fuel_calculator.core.BaseViewModel
import com.FreedAsd.fuel_calculator.core.Event
import com.FreedAsd.fuel_calculator.data.Repository
import com.FreedAsd.fuel_calculator.domain.distance.interactor.Interactor
import com.FreedAsd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.FreedAsd.fuel_calculator.presentation.distance.DistanceInputUi
import com.FreedAsd.fuel_calculator.presentation.distance.DistanceResultUi
import com.FreedAsd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper

class DistanceViewModel(
    private val interactor: Interactor,
    private val inputMapper: BaseInputUiToDomainMapper,
    private val resultMapper: BaseResultDomainToUiMapper
): BaseViewModel<Repository, Event<DistanceResultUi>>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<DistanceResultUi>>) {
        liveData.observe(owner, observer)
    }

    fun calculate(input: DistanceInputUi.Base) : DistanceResultUi {
        val result = interactor.calcMaxDistance(input.map(inputMapper)).map(resultMapper)
        liveData.value = Event(result)
        return result
    }
}