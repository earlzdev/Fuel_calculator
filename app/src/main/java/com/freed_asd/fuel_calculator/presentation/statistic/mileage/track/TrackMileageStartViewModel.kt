package com.freed_asd.fuel_calculator.presentation.statistic.mileage.track

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.track.ConsTrackDomainToUiMapper
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.dbModel.ConsTrackDbItemUi
import kotlinx.coroutines.flow.map

class TrackMileageStartViewModel(
    private val consInteractor: ConsInteractor,
    private val trackDomainToUiMapper: ConsTrackDomainToUiMapper.Base
) : ViewModel() {

    val valueList: LiveData<List<ConsTrackDbItemUi>> = consInteractor.allTrackDbValues().map { list ->
        list.map { it.mapToUi(trackDomainToUiMapper) }
    }.asLiveData()
}