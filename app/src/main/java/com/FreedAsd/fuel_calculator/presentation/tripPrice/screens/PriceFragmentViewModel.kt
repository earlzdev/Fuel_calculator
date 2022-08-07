package com.FreedAsd.fuel_calculator.presentation.tripPrice.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.FreedAsd.fuel_calculator.core.BaseViewModel
import com.FreedAsd.fuel_calculator.core.Event
import com.FreedAsd.fuel_calculator.data.Repository
import com.FreedAsd.fuel_calculator.domain.tripPrice.usecase.CalcTripPriceUseCase
import com.FreedAsd.fuel_calculator.presentation.tripPrice.PriceInputDataUi
import com.FreedAsd.fuel_calculator.presentation.tripPrice.PriceResultUi
import com.FreedAsd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceInputUiMapper
import com.FreedAsd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceResultUiMapper

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