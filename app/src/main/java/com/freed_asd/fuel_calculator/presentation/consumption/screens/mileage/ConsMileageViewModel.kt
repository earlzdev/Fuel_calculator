package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.freed_asd.fuel_calculator.presentation.core.BaseViewModel
import com.freed_asd.fuel_calculator.presentation.core.Event
import com.freed_asd.fuel_calculator.domain.consumption.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.models.ConsCalcValuesUi
import com.freed_asd.fuel_calculator.presentation.consumption.models.ConsCalcResultUi
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import kotlinx.coroutines.launch

class ConsMileageViewModel (
    private val consInteractor: ConsInteractor,
    private val inputMapper: BaseConsInputUiToDomainMapper,
    private val resultMapper: BaseConsResultDomainToUiMapper
) : BaseViewModel<Event<ConsCalcResultUi>>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<ConsCalcResultUi>>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun calculate(input: ConsCalcValuesUi.Base) : ConsCalcResultUi {
        val result = consInteractor.calcConsumption(input.map(inputMapper)).map(resultMapper)
        liveData.value = Event(result)
        return result
    }

    fun setIntoStats(consumption: Float, driveRegime: String, mileage: Float) {

        viewModelScope.launch {
            consInteractor.insertValueToDb(driveRegime, mileage, consumption)
        }
    }
}
