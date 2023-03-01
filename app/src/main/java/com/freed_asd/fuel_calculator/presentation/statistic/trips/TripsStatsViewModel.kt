package com.freed_asd.fuel_calculator.presentation.statistic.trips

import androidx.lifecycle.*
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceInteractor
import com.freed_asd.fuel_calculator.presentation.price.dbItem.BasePriceDbItemDomainMapperUi
import com.freed_asd.fuel_calculator.presentation.price.dbItem.SavedTripPriceUi
import com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler.SwipeAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TripsStatsViewModel(
    private val priceInteractor: PriceInteractor,
    private val priceDbDomainMapper: BasePriceDbItemDomainMapperUi,
): ViewModel(), SwipeAction {

    private val savedTripPricesList: MutableLiveData<List<SavedTripPriceUi>> = MutableLiveData()

    fun fetchAllDbValues() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = priceInteractor.fetchAllPriceValuesFromDb().map {
                it.mapToUi(priceDbDomainMapper)
            }
            withContext(Dispatchers.Main) {
                savedTripPricesList.value = list
            }
        }
    }

    fun observeTripPriceLiveData(owner: LifecycleOwner, observer: Observer<List<SavedTripPriceUi>>) {
        savedTripPricesList.observe(owner, observer)
    }

    override fun removeItem(item: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            priceInteractor.deleteItem(item)
        }
    }
}