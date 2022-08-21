package com.freed_asd.fuel_calculator.presentation.statistic.mileage.city

import androidx.lifecycle.*
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.city.ConsCityDomainToUiMapper
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.dbModel.ConsCityDbItemUi
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.dbModel.ConsMixedDbItemUi
import kotlinx.coroutines.flow.map

class CityMileageStatsViewModel(
    private val consInteractor: ConsInteractor,
    private val cityDomainToUiMapper: ConsCityDomainToUiMapper.Base
) : ViewModel() {

    val valueList: LiveData<List<ConsCityDbItemUi>> = consInteractor.allCityDbValues().map { list ->
        list.map { it.mapToUi(cityDomainToUiMapper) }
    }.asLiveData()
}