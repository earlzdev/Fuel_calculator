package com.FreedAsd.fuel_calculator.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.usecase.CalcTripPriceUseCase
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers.PriceInputUiMapper
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers.PriceResultUiMapper
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.views.TripPriceViewModel

class ViewModelsFactory(
    private val calcPriceUseCase: CalcTripPriceUseCase,
    private val inputMapper: PriceInputUiMapper,
    private val resultMapper: PriceResultUiMapper
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TripPriceViewModel::class.java) -> TripPriceViewModel(
                calcPriceUseCase,
                inputMapper,
                resultMapper
            )
            else -> throw IllegalStateException("model class $modelClass not found")
        } as T
    }
}