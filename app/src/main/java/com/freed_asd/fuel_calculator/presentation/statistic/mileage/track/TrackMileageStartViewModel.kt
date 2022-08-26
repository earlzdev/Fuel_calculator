package com.freed_asd.fuel_calculator.presentation.statistic.mileage.track

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.track.ConsTrackDomainToUiMapper
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.dbModel.ConsTrackDbItemUi
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class TrackMileageStartViewModel(
    private val consInteractor: ConsInteractor,
    private val trackDomainToUiMapper: ConsTrackDomainToUiMapper.Base
) : ViewModel() {

    val valueList: LiveData<List<ConsTrackDbItemUi>> = consInteractor.allTrackDbValues().map { list ->
        list.map { it.mapToUi(trackDomainToUiMapper) }
    }.asLiveData()

    fun removeValue(id: Long) {
        viewModelScope.launch {
            consInteractor.deleteTrackValue(id)
        }
    }
}