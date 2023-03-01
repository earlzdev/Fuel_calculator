package com.freed_asd.fuel_calculator.presentation.consumption.screens.distance

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.presentation.core.BaseViewModel
import com.freed_asd.fuel_calculator.presentation.core.Event
import com.freed_asd.fuel_calculator.domain.consumption.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.models.ConsCalcValuesUi
import com.freed_asd.fuel_calculator.presentation.consumption.models.ConsCalcResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper

class ConsDistanceViewModel(
    private val interactor: ConsInteractor,
    private val inputMapper: BaseConsInputUiToDomainMapper,
    private val resultMapper: BaseConsResultDomainToUiMapper
) : BaseViewModel<Event<ConsCalcResultUi>>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<ConsCalcResultUi>>) {
        liveData.observe(owner, observer)
    }

    fun calculate(input: ConsCalcValuesUi.Base) : ConsCalcResultUi {
        val result = interactor.calcConsumption(input.map(inputMapper)).map(resultMapper)
        liveData.value = Event(result)
        return result
    }
}