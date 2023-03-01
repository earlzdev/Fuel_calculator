package com.freed_asd.fuel_calculator.presentation.price.screens.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.freed_asd.fuel_calculator.presentation.core.BaseViewModel
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceDbItemUiMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceInteractor
import com.freed_asd.fuel_calculator.presentation.price.PriceResultUi
import com.freed_asd.fuel_calculator.presentation.price.dbItem.SavedTripPriceUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel(
    private val priceInteractor: PriceInteractor,
    private val priceDbUiToDomainMapper: BasePriceDbItemUiMapper
): BaseViewModel<PriceResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<PriceResultUi>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun provideResult(result: PriceResultUi) {
        liveData.value = result
    }

    fun insertIntoDb(name: String) {

        val value = liveData.value
        val distance = value?.distance()
        val needFuel = value?.needFuel()
        val generalPrice = value?.generalPrice()
        val everyonePrice = value?.everyonePrice()

        if (distance == null || needFuel == null || generalPrice == null || everyonePrice == null) return

        viewModelScope.launch(Dispatchers.IO) {
            priceInteractor.insertIntoDb(SavedTripPriceUi.Base(
                0,
                name,
                distance,
                needFuel,
                generalPrice,
                everyonePrice
            ).mapToDomain(priceDbUiToDomainMapper))
        }
    }
}