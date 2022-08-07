package com.freed_asd.fuel_calculator.presentation.consumption.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.ConsInputUi
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper

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