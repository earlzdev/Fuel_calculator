package com.freed_asd.fuel_calculator.presentation.statistic.trips.fullStats

import androidx.lifecycle.*
import com.freed_asd.fuel_calculator.presentation.core.BaseViewModel
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceInteractor
import com.freed_asd.fuel_calculator.presentation.price.dbItem.BasePriceDbItemDomainMapperUi
import com.freed_asd.fuel_calculator.presentation.price.dbItem.SavedTripPriceUi
import kotlinx.coroutines.launch

class TripFullStatsViewModel(
    private val priceInteractor: PriceInteractor,
    private val priceDomainToUiDbMapper: BasePriceDbItemDomainMapperUi,
) : BaseViewModel<SavedTripPriceUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<SavedTripPriceUi>) {
        liveData.observe(owner, observer)
    }

    fun getItemById(id: Long) {
        viewModelScope.launch {
            val item = priceInteractor.dbItemById(id)
            liveData.value = item.mapToUi(priceDomainToUiDbMapper)
        }
    }

    fun updateItem(item: Long, newName: String) {
        viewModelScope.launch {
            priceInteractor.updateItem(item, newName)
        }
    }
}