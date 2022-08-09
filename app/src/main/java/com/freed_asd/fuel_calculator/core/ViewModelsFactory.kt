package com.freed_asd.fuel_calculator.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.consumption.screens.ConsFragViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.screens.dialog.ConsDialogViewModel
import com.freed_asd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.distance.screens.DistanceViewModel
import com.freed_asd.fuel_calculator.presentation.distance.screens.dialog.DialogFragmentViewModel
import com.freed_asd.fuel_calculator.presentation.tripPrice.mappers.BasePriceResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.tripPrice.screens.PriceFragmentViewModel
import com.freed_asd.fuel_calculator.presentation.tripPrice.screens.dialog.ResultViewModel

class ViewModelsFactory(
    private val priceInteractor: PriceInteractor,
    private val inputTripMapper: BasePriceInputUiToDomainMapper,
    private val resultTripMapper: BasePriceResultDomainToUiMapper,
    private val distanceInteractor: DistanceInteractor,
    private val inputDistanceMapper: BaseInputUiToDomainMapper,
    private val resultDistanceMapper: BaseResultDomainToUiMapper,
    private val consInteractor: ConsInteractor,
    private val inputConsMapper: BaseConsInputUiToDomainMapper,
    private val resultConsMapper: BaseConsResultDomainToUiMapper
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PriceFragmentViewModel::class.java) -> PriceFragmentViewModel(
                priceInteractor,
                inputTripMapper,
                resultTripMapper
            )
            modelClass.isAssignableFrom(ResultViewModel::class.java) -> ResultViewModel()
            modelClass.isAssignableFrom(DistanceViewModel::class.java) -> DistanceViewModel(
                distanceInteractor,
                inputDistanceMapper,
                resultDistanceMapper
            )
            modelClass.isAssignableFrom(DialogFragmentViewModel::class.java) -> DialogFragmentViewModel()
            modelClass.isAssignableFrom(ConsFragViewModel::class.java) -> ConsFragViewModel(
                consInteractor,
                inputConsMapper,
                resultConsMapper
            )
            modelClass.isAssignableFrom(ConsDialogViewModel::class.java) -> ConsDialogViewModel()
            else -> throw IllegalStateException("model class $modelClass not found")
        } as T
    }
}