package com.freed_asd.fuel_calculator.sl.stats.trips

import com.freed_asd.fuel_calculator.presentation.price.dbItem.BasePriceDbItemDomainMapperUi
import com.freed_asd.fuel_calculator.presentation.statistic.trips.fullStats.TripFullStatsViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule
import com.freed_asd.fuel_calculator.sl.price.PriceCoreModule

class StatsFullModule(private val core: PriceCoreModule) : BaseModule<TripFullStatsViewModel> {

    override fun viewModel(): TripFullStatsViewModel {
        val interactor = core.interactor
        val priceDomainToUiDbMapper = BasePriceDbItemDomainMapperUi()
        return TripFullStatsViewModel(interactor, priceDomainToUiDbMapper)
    }
}