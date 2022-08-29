package com.freed_asd.fuel_calculator.sl

import com.freed_asd.fuel_calculator.sl.consumption.*
import com.freed_asd.fuel_calculator.sl.distance.DistanceCoreModule
import com.freed_asd.fuel_calculator.sl.distance.DistanceDialogModule
import com.freed_asd.fuel_calculator.sl.distance.DistanceMainModule
import com.freed_asd.fuel_calculator.sl.price.PriceCoreModule
import com.freed_asd.fuel_calculator.sl.price.PriceMainModule
import com.freed_asd.fuel_calculator.sl.price.PriceResultModule
import com.freed_asd.fuel_calculator.sl.stats.mileage.CityModule
import com.freed_asd.fuel_calculator.sl.stats.mileage.MixedModule
import com.freed_asd.fuel_calculator.sl.stats.mileage.TrackModule
import com.freed_asd.fuel_calculator.sl.stats.trips.StatsFullModule
import com.freed_asd.fuel_calculator.sl.stats.trips.StatsMainModule

interface Dependencies {

    fun module(feature: Feature) : BaseModule<*>

    class Base(
        private val distanceCoreModule: DistanceCoreModule,
        private val priceCoreModule: PriceCoreModule,
        private val consCoreModule: ConsCoreModule
    ) : Dependencies {
        override fun module(feature: Feature): BaseModule<*> {
            return when(feature) {
                Feature.DISTANCE_MAIN -> DistanceMainModule(distanceCoreModule)
                Feature.DISTANCE_RESULT_DIALOG -> DistanceDialogModule(distanceCoreModule)
                Feature.PRICE_MAIN -> PriceMainModule(priceCoreModule)
                Feature.PRICE_RESULT_DIALOG -> PriceResultModule(priceCoreModule)
                Feature.CONS_MAIN -> ConsMainModule(consCoreModule)
                Feature.CONS_DISTANCE_BASE -> ConsDistanceBaseModule(consCoreModule)
                Feature.CONS_DISTANCE_RESULT -> ConsDistanceResultModule(consCoreModule)
                Feature.CONS_MILEAGE_BASE -> ConsMileageBaseModule(consCoreModule)
                Feature.CONS_MILEAGE_RESULT -> ConsMileageResultModule(consCoreModule)
                Feature.STATS_TRIPS_BASE -> StatsMainModule(priceCoreModule)
                Feature.STATS_TRIPS_FULL -> StatsFullModule(priceCoreModule)
                Feature.STATS_MILEAGE_TRACK -> TrackModule(consCoreModule)
                Feature.STATS_MILEAGE_CITY -> CityModule(consCoreModule)
                Feature.STATS_MILEAGE_MIXED -> MixedModule(consCoreModule)
            }
        }
    }
}