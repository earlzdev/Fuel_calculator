package com.freed_asd.fuel_calculator.sl.consumption

import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.ConsMileageViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule

class ConsMileageBaseModule(private val core: ConsCoreModule) : BaseModule<ConsMileageViewModel> {

    override fun viewModel(): ConsMileageViewModel {
        val interactor = core.interactor
        val inputMapper = BaseConsInputUiToDomainMapper()
        val resultMapper = BaseConsResultDomainToUiMapper()
        return ConsMileageViewModel(interactor, inputMapper, resultMapper)
    }
}