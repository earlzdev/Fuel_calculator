package com.FreedAsd.fuel_calculator.presentation.calc_trip_price.views

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.FreedAsd.fuel_calculator.core.BaseViewModel
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.CalcTripPriceRepository
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.usecase.CalcTripPriceUseCase
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceInputDataUi
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceResultUi
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers.PriceInputUiMapper
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers.PriceResultUiMapper

class TripPriceViewModel(
    private val calcPriceUseCase: CalcTripPriceUseCase,
    private val inputMapper: PriceInputUiMapper,
    private val resultMapper: PriceResultUiMapper
) : BaseViewModel<CalcTripPriceRepository, PriceResultUi>() {

    private val answerLiveData = MutableLiveData<PriceResultUi>()

    override fun observe(owner: LifecycleOwner, observer: Observer<PriceResultUi>) {
        answerLiveData.observe(owner, observer)
    }

    fun calculateAnswer(data: PriceInputDataUi): PriceResultUi {
        Log.d("tag", "calculateAnswer: ${resultMapper.map(calcPriceUseCase.calcTripPrice(inputMapper.map(data)))}")
        return resultMapper.map(calcPriceUseCase.calcTripPrice(inputMapper.map(data)))
    }
}