package com.FreedAsd.fuel_calculator.presentation.tripPrice.screens.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.FreedAsd.fuel_calculator.core.BaseViewModel
import com.FreedAsd.fuel_calculator.data.Repository
import com.FreedAsd.fuel_calculator.presentation.tripPrice.PriceResultUi

class ResultViewModel: BaseViewModel<Repository, PriceResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<PriceResultUi>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun provideResult(result: PriceResultUi) {
        liveData.value = result
    }
}