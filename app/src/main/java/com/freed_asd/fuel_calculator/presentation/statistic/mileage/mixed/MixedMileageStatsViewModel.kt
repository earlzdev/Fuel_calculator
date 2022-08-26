package com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed

import android.content.Context
import androidx.lifecycle.*
import com.freed_asd.fuel_calculator.R
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.mixed.ConsMixedDbItemDomain
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.mixed.ConsMixedDomainToUiMapper
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.presentation.price.dbItem.PriceDbItemUi
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.dbModel.ConsMixedDbItemUi
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
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