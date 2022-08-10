package com.freed_asd.fuel_calculator.presentation.tripPrice.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.tripPrice.usecase.CalcTripPriceUseCase
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceInputDataUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceResultUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceInputUiMapper
import com.freed_asd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceResultUiMapper

class PriceFragmentViewModel(
    private val calcPriceUseCase: CalcTripPriceUseCase,
    private val inputMapper: PriceInputUiMapper,
    private val resultMapper: PriceResultUiMapper
) : BaseViewModel<Repository, Event<PriceResultUi>>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<PriceResultUi>>) {
        liveData.observe(owner, observer)
    }

    fun calculateAnswer(data:PriceInputDataUi): PriceResultUi {
        val result = resultMapper.map(calcPriceUseCase.calcTripPrice(inputMapper.map(data)))
        liveData.value = Event(result)
        return result
    }
}