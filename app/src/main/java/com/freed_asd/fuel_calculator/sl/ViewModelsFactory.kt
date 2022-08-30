package com.freed_asd.fuel_calculator.sl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.freed_asd.fuel_calculator.presentation.consumption.screens.ConsFragViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.ConsDistanceViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.dialog.DistanceDialogViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.ConsMileageViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog.MileageDialogViewModel
import com.freed_asd.fuel_calculator.presentation.distance.screens.DistanceViewModel
import com.freed_asd.fuel_calculator.presentation.distance.screens.dialog.DialogFragmentViewModel
import com.freed_asd.fuel_calculator.presentation.price.screens.PriceFragmentViewModel
import com.freed_asd.fuel_calculator.presentation.price.screens.dialog.ResultViewModel
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.CityMileageStatsViewModel
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.MixedMileageStatsViewModel
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.TrackMileageStartViewModel
import com.freed_asd.fuel_calculator.presentation.statistic.trips.TripsStatsViewModel
import com.freed_asd.fuel_calculator.presentation.statistic.trips.fullStats.TripFullStatsViewModel
import com.freed_asd.fuel_calculator.sl.consumption.ConsMainModule

class ViewModelsFactory(private val dependencies: Dependencies) : ViewModelProvider.Factory {

    private val map = HashMap<Class<*>, Feature>().apply {
        put(DialogFragmentViewModel::class.java, Feature.DISTANCE_RESULT_DIALOG )
        put(DistanceViewModel::class.java, Feature.DISTANCE_MAIN)
        put(PriceFragmentViewModel::class.java, Feature.PRICE_MAIN)
        put(ResultViewModel::class.java, Feature.PRICE_RESULT_DIALOG)
        put(ConsFragViewModel::class.java, Feature.CONS_MAIN)
        put(ConsDistanceViewModel::class.java, Feature.CONS_DISTANCE_BASE)
        put(DistanceDialogViewModel::class.java, Feature.CONS_DISTANCE_RESULT)
        put(ConsMileageViewModel::class.java, Feature.CONS_MILEAGE_BASE)
        put(MileageDialogViewModel::class.java, Feature.CONS_MILEAGE_RESULT)
        put(TripsStatsViewModel::class.java, Feature.STATS_TRIPS_BASE)
        put(TripFullStatsViewModel::class.java, Feature.STATS_TRIPS_FULL)
        put(TrackMileageStartViewModel::class.java, Feature.STATS_MILEAGE_TRACK)
        put(CityMileageStatsViewModel::class.java, Feature.STATS_MILEAGE_CITY)
        put(MixedMileageStatsViewModel::class.java, Feature.STATS_MILEAGE_MIXED)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val feature = map[modelClass] ?: throw IllegalStateException("Feature not found")
        return dependencies.module(feature).viewModel() as T
    }
}