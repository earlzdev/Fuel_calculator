package com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed

import androidx.lifecycle.*
import com.freed_asd.fuel_calculator.domain.consumption.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsMixedDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.dbModel.ConsMixedDbItemUi
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MixedMileageStatsViewModel(
    private val consInteractor: ConsInteractor,
    private val domainToUiMapper: ConsMixedDomainToUiMapper.Base
) : ViewModel() {

    val valueList: LiveData<List<ConsMixedDbItemUi>> = consInteractor.allMixedDbValues().map { list ->
        list.map { it.mapToUi(domainToUiMapper) }
    }.asLiveData()

    fun removeValue(id: Long) {
        viewModelScope.launch {
            consInteractor.deleteMixedValue(id)
        }
    }

}