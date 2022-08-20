package com.freed_asd.fuel_calculator.presentation.statistic.trips

import androidx.lifecycle.*
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.presentation.price.dbItem.BasePriceDbItemDomainMapperUi
import com.freed_asd.fuel_calculator.presentation.price.dbItem.PriceDbItemUi
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.SwipeAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TripsStatsViewModel(
    private val priceInteractor: PriceInteractor,
    private val priceDbDomainMapper: BasePriceDbItemDomainMapperUi,
): ViewModel(), SwipeAction {

    val itemList: LiveData<List<PriceDbItemUi>> = priceInteractor.allDbValues().map { list ->
        list.map { priceDbDomainMapper.mapToUi(
            it.id(),
            it.name(),
            it.distance(),
            it.needFuel(),
            it.generalPrice(),
            it.everyonePrice()) }
    }.asLiveData()

    override fun removeItem(item: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            priceInteractor.deleteItem(item)
        }
    }
}
