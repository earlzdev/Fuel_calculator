package com.freed_asd.fuel_calculator.sl.consumption

import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.consumption.screens.ConsFragViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule

class ConsMainModule(private val core: ConsCoreModule) : BaseModule<ConsFragViewModel> {

    override fun viewModel(): ConsFragViewModel {
        val interactor = core.interactor
        val inputMapper = BaseConsInputUiToDomainMapper()
        val resultMapper = BaseConsResultDomainToUiMapper()
        return ConsFragViewModel(interactor, inputMapper, resultMapper)
    }
}