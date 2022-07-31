package com.FreedAsd.fuel_calculator.presentation.calc_trip_price.views.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.FreedAsd.fuel_calculator.core.BaseViewModel
import com.FreedAsd.fuel_calculator.data.Repository
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceResultUi

class ResultViewModel: BaseViewModel<Repository, PriceResultUi>() {

    private val resultLiveData = MutableLiveData<PriceResultUi>()

    override fun observe(owner: LifecycleOwner, observer: Observer<PriceResultUi>) {
        super.observe(owner, observer)
        resultLiveData.observe(owner, observer)
    }

    fun provideResult(result: PriceResultUi) {
        resultLiveData.value = result
    }
}