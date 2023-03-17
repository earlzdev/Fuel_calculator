package com.freed_asd.fuel_calculator.sl.stats.mileage

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsTrackDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.TrackMileageStartViewModel
import com.freed_asd.fuel_calculator.sl.BaseModule
import com.freed_asd.fuel_calculator.sl.consumption.ConsCoreModule

class TrackModule(private val core: ConsCoreModule) : BaseModule<TrackMileageStartViewModel> {

    override fun viewModel(): TrackMileageStartViewModel {
        val interactor = core.interactor
        val trackDomainToUiMapper = ConsTrackDomainToUiMapper.Base()
        return TrackMileageStartViewModel(interactor, trackDomainToUiMapper)
    }
}