package com.freed_asd.fuel_calculator.presentation.tripPrice.screens

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.core.Event
import com.freed_asd.fuel_calculator.data.Repository
<<<<<<< HEAD
import com.freed_asd.fuel_calculator.domain.tripPrice.usecase.CalcTripPriceUseCase
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceInputDataUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceResultUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceInputUiMapper
import com.freed_asd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceResultUiMapper

class PriceFragmentViewModel(
    private val calcPriceUseCase: CalcTripPriceUseCase,
    private val inputMapper: PriceInputUiMapper,
    private val resultMapper: PriceResultUiMapper
=======
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceInputUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceResultUi
import com.freed_asd.fuel_calculator.presentation.tripPrice.mappers.BasePriceResultDomainToUiMapper

class PriceFragmentViewModel(
    private val interactor: PriceInteractor,
    private val inputMapper: BasePriceInputUiToDomainMapper,
    private val resultMapper: BasePriceResultDomainToUiMapper
>>>>>>> master
) : BaseViewModel<Repository, Event<PriceResultUi>>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<Event<PriceResultUi>>) {
        liveData.observe(owner, observer)
    }

<<<<<<< HEAD
    fun calculateAnswer(data:PriceInputDataUi): PriceResultUi {
        val result = resultMapper.map(calcPriceUseCase.calcTripPrice(inputMapper.map(data)))
=======
    fun calculateAnswer(input: PriceInputUi): PriceResultUi {
        val result = interactor.calcTripPrice(input.map(inputMapper)).map(resultMapper)
>>>>>>> master
        liveData.value = Event(result)
        return result
    }
}