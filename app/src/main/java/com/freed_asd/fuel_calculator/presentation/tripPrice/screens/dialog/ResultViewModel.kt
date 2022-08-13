package com.freed_asd.fuel_calculator.presentation.tripPrice.screens.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.presentation.tripPrice.PriceResultUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel(
    private val priceInteractor: PriceInteractor
): BaseViewModel<Repository, PriceResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<PriceResultUi>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun provideResult(result: PriceResultUi) {
        liveData.value = result
    }

    fun insertIntoDb() {

        val value = liveData.value
        val distance = value?.distance()
        val needFuel = value?.needFuel()
        val generalPrice = value?.generalPrice()
        val everyonePrice = value?.everyonePrice()
        val passengers = value?.passengers()

        if (distance == null || needFuel == null || generalPrice == null || everyonePrice == null || passengers == null) return
        viewModelScope.launch(Dispatchers.IO) {
            priceInteractor.insertIntoDb(distance, needFuel, generalPrice, everyonePrice, passengers)
        }
    }
}