package com.freed_asd.fuel_calculator.sl.distance

import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freed_asd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.distance.screens.DistanceViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule

class DistanceMainModule(private val core: DistanceCoreModule) : BaseModule<DistanceViewModel> {

    override fun viewModel(): DistanceViewModel {
        val interactor = core.interactor
        val inputMapper = BaseInputUiToDomainMapper()
        val resultMapper =  BaseResultDomainToUiMapper()
        return DistanceViewModel(interactor, inputMapper, resultMapper)
    }
}