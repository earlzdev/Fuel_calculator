package com.freed_asd.fuel_calculator.sl.stats.mileage

import com.freed_asd.fuel_calculator.domain.distance.mappers.ConsCityDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.CityMileageStatsViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule
import com.freed_asd.fuel_calculator.sl.consumption.ConsCoreModule

class CityModule(private val core: ConsCoreModule) : BaseModule<CityMileageStatsViewModel> {

    override fun viewModel(): CityMileageStatsViewModel {
        val interactor = core.interactor
        val cityDomainToUiMapper = ConsCityDomainToUiMapper.Base()
        return CityMileageStatsViewModel(interactor, cityDomainToUiMapper)
    }
}