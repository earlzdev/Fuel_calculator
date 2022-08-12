package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.ConsInputUi
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import kotlinx.coroutines.launch

class ConsMileageViewModel (
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

    fun setIntoStats(driveRegime: String, mileage: Float) {

        val consumption = liveData.value?.value?.consumption()
        viewModelScope.launch {
            consInteractor.insertValueToDb(driveRegime, mileage, consumption!!)
        }
    }
}
