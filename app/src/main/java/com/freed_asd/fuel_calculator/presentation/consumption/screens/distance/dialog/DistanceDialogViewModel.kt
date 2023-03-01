package com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.presentation.consumption.models.ConsCalcResultUi
import com.freed_asd.fuel_calculator.presentation.core.BaseViewModel

class DistanceDialogViewModel : BaseViewModel<ConsCalcResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<ConsCalcResultUi>) {
        liveData.observe(owner, observer)
    }

    fun provideResult(result: ConsCalcResultUi) {
        liveData.value = result
    }
}