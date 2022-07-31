package com.FreedAsd.fuel_calculator.presentation.calc_trip_price.views

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.FreedAsd.fuel_calculator.core.BaseViewModel
import com.FreedAsd.fuel_calculator.core.Event
import com.FreedAsd.fuel_calculator.data.Repository
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.usecase.CalcTripPriceUseCase
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceInputDataUi
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceResultUi
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers.PriceInputUiMapper
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers.PriceResultUiMapper

class PriceFragmentViewModel(
    private val calcPriceUseCase: CalcTripPriceUseCase,
    private val inputMapper: PriceInputUiMapper,
    private val resultMapper: PriceResultUiMapper
) : BaseViewModel<Repository, Event<PriceResultUi>>() {

    private val answerLiveData = MutableLiveData<Event<PriceResultUi>>()

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<PriceResultUi>>) {
        answerLiveData.observe(owner, observer)
    }

    fun calculateAnswer(data:PriceInputDataUi): PriceResultUi {
        val result = resultMapper.map(calcPriceUseCase.calcTripPrice(inputMapper.map(data)))
        answerLiveData.value = Event(result)
        return result
    }
}