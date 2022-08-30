package com.freed_asd.fuel_calculator.sl.stats.trips

import com.freed_asd.fuel_calculator.presentation.price.dbItem.BasePriceDbItemDomainMapperUi
import com.freed_asd.fuel_calculator.presentation.statistic.trips.TripsStatsViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule
import com.freed_asd.fuel_calculator.sl.price.PriceCoreModule

class StatsMainModule(private val core: PriceCoreModule) : BaseModule<TripsStatsViewModel> {

    override fun viewModel(): TripsStatsViewModel {
        val interactor = core.interactor
        val priceDbDomainMapper = BasePriceDbItemDomainMapperUi()
        return TripsStatsViewModel(interactor, priceDbDomainMapper)
    }
}