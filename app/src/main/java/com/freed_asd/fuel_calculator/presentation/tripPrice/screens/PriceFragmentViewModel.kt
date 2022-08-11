package com.freed_asd.fuel_calculator.presentation.tripPrice.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceInputUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceResultUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.mappers.BasePriceResultDomainToUiMapper

class PriceFragmentViewModel(
    private val interactor: PriceInteractor,
    private val inputMapper: BasePriceInputUiToDomainMapper,
    private val resultMapper: BasePriceResultDomainToUiMapper
) : BaseViewModel<Repository, Event<PriceResultUi>>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<PriceResultUi>>) {
        liveData.observe(owner, observer)
    }

    fun calculateAnswer(input: PriceInputUi): PriceResultUi {
        val result = interactor.calcTripPrice(input.map(inputMapper)).map(resultMapper)
        liveData.value = Event(result)
        return result
    }
}