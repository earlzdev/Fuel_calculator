package com.freed_asd.fuel_calculator.presentation.statistic.mileage.city

import androidx.lifecycle.*
import com.freed_asd.fuel_calculator.domain.consumption.ConsInteractor
import com.freed_asd.fuel_calculator.domain.distance.mappers.ConsCityDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.dbModel.ConsCityDbItemUi
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CityMileageStatsViewModel(
    private val consInteractor: ConsInteractor,
    private val cityDomainToUiMapper: ConsCityDomainToUiMapper.Base
) : ViewModel() {

    val valueList: LiveData<List<ConsCityDbItemUi>> = consInteractor.allCityDbValues().map { list ->
        list.map { it.mapToUi(cityDomainToUiMapper) }
    }.asLiveData()

    fun removeValue(id: Long) {
        viewModelScope.launch {
            consInteractor.deleteCityValue(id)
        }
    }
}