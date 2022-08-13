package com.freed_asd.fuel_calculator.presentation.distance.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.distance.DistanceInputUi
import com.freed_asd.fuel_calculator.presentation.distance.DistanceResultUi
import com.freed_asd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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