package com.freed_asd.fuel_calculator.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
<<<<<<< HEAD
import com.freed_asd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.usecase.CalcTripPriceUseCase
import com.freed_asd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.distance.screens.DistanceViewModel
import com.freed_asd.fuel_calculator.presentation.distance.screens.dialog.DialogFragmentViewModel
import com.freed_asd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceInputUiMapper
import com.freed_asd.fuel_calculator.presentation.tripPrice.uiPriceMappers.PriceResultUiMapper
import com.freed_asd.fuel_calculator.presentation.tripPrice.screens.PriceFragmentViewModel
import com.freed_asd.fuel_calculator.presentation.tripPrice.screens.dialog.ResultViewModel
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.consumption.screens.ConsFragViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.ConsDistanceViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.dialog.DistanceDialogViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.ConsMileageViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog.MileageDialogViewModel

class ViewModelsFactory(
    private val calcPriceUseCase: CalcTripPriceUseCase,
    private val inputTripMapper: PriceInputUiMapper,
    private val resultTripMapper: PriceResultUiMapper,
=======
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
>>>>>>> master
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
<<<<<<< HEAD
                calcPriceUseCase,
=======
                priceInteractor,
>>>>>>> master
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
<<<<<<< HEAD
            modelClass.isAssignableFrom(ConsMileageViewModel::class.java) -> ConsMileageViewModel(
=======
            modelClass.isAssignableFrom(ConsFragViewModel::class.java) -> ConsFragViewModel(
>>>>>>> master
                consInteractor,
                inputConsMapper,
                resultConsMapper
            )
<<<<<<< HEAD
            modelClass.isAssignableFrom(MileageDialogViewModel::class.java) -> MileageDialogViewModel()
            modelClass.isAssignableFrom(ConsFragViewModel::class.java) -> ConsFragViewModel()
            modelClass.isAssignableFrom(ConsDistanceViewModel::class.java) -> ConsDistanceViewModel(
                consInteractor,
                inputConsMapper,
                resultConsMapper)
            modelClass.isAssignableFrom(DistanceDialogViewModel::class.java) -> DistanceDialogViewModel()
=======
            modelClass.isAssignableFrom(ConsDialogViewModel::class.java) -> ConsDialogViewModel()
>>>>>>> master
            else -> throw IllegalStateException("model class $modelClass not found")
        } as T
    }
}