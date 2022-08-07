package com.freedasd.fuel_calculator.presentation.consumption.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freedasd.fuel_calculator.core.BaseViewModel
import com.freedasd.fuel_calculator.core.Event
import com.freedasd.fuel_calculator.data.Repository
import com.freedasd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freedasd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freedasd.fuel_calculator.presentation.consumption.ConsInputUi
import com.freedasd.fuel_calculator.presentation.consumption.ConsResultUi
import com.freedasd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper

class ConsFragViewModel(
    private val consInteractor: ConsInteractor,
    private val inputMapper: BaseConsInputUiToDomainMapper,
    private val resultMapper: BaseConsResultDomainToUiMapper
) : BaseViewModel<Repository, Event<ConsResultUi>>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<ConsResultUi>>) {
        liveData.observe(owner, observer)
    }

    fun calculate(input: ConsInputUi.Base) : ConsResultUi {
        val result = consInteractor.calcConsumption(input.map(inputMapper)).map(resultMapper)
        liveData.value = Event(result)
        return result
    }
}