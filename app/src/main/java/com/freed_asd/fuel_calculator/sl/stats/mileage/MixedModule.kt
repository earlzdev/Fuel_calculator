package com.freed_asd.fuel_calculator.sl.stats.mileage

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsMixedDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.MixedMileageStatsViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule
import com.freed_asd.fuel_calculator.sl.consumption.ConsCoreModule

class MixedModule(private val core: ConsCoreModule) : BaseModule<MixedMileageStatsViewModel> {

    override fun viewModel(): MixedMileageStatsViewModel {
        val interactor = core.interactor
        val domainToUiMapper = ConsMixedDomainToUiMapper.Base()
        return MixedMileageStatsViewModel(interactor, domainToUiMapper)
    }
}