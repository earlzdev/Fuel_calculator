package com.freed_asd.fuel_calculator.sl.consumption

import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.ConsDistanceViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule

class ConsDistanceBaseModule(private val core: ConsCoreModule) : BaseModule<ConsDistanceViewModel> {

    override fun viewModel(): ConsDistanceViewModel {
        val interactor = core.interactor
        val inputMapper = BaseConsInputUiToDomainMapper()
        val resultMapper = BaseConsResultDomainToUiMapper()
        return ConsDistanceViewModel(interactor, inputMapper, resultMapper)
    }
}