package com.FreedAsd.fuel_calculator.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.FreedAsd.fuel_calculator.domain.distance.interactor.Interactor
import com.FreedAsd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.FreedAsd.fuel_calculator.domain.tripPrice.usecase.CalcTripPriceUseCase
import com.FreedAsd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import com.FreedAsd.fuel_calculator.presentation.distance.screens.DistanceViewModel
import com.FreedAsd.fuel_calculator.presentation.distance.screens.dialog.DialogFragmentViewModel
import com.FreedAsd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceInputUiMapper
import com.FreedAsd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceResultUiMapper
import com.FreedAsd.fuel_calculator.presentation.tripPrice.screens.PriceFragmentViewModel
import com.FreedAsd.fuel_calculator.presentation.tripPrice.screens.dialog.ResultViewModel

class ViewModelsFactory(
    private val calcPriceUseCase: CalcTripPriceUseCase,
    private val inputTripMapper: PriceInputUiMapper,
    private val resultTripMapper: PriceResultUiMapper,
    private val interactor: Interactor,
    private val inputDistanceMapper: BaseInputUiToDomainMapper,
    private val resultDistanceMapper: BaseResultDomainToUiMapper
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PriceFragmentViewModel::class.java) -> PriceFragmentViewModel(
                calcPriceUseCase,
                inputTripMapper,
                resultTripMapper
            )
            modelClass.isAssignableFrom(ResultViewModel::class.java) -> ResultViewModel()
            modelClass.isAssignableFrom(DistanceViewModel::class.java) -> DistanceViewModel(
                interactor,
                inputDistanceMapper,
                resultDistanceMapper
            )
            modelClass.isAssignableFrom(DialogFragmentViewModel::class.java) -> DialogFragmentViewModel()
            else -> throw IllegalStateException("model class $modelClass not found")
        } as T
    }
}