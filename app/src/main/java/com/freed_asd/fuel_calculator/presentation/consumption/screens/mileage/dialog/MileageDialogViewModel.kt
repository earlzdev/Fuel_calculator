package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.presentation.core.BaseViewModel
import com.freed_asd.fuel_calculator.presentation.consumption.models.ConsCalcResultUi

class MileageDialogViewModel: BaseViewModel<ConsCalcResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<ConsCalcResultUi>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun provideResult(result: ConsCalcResultUi) {
        liveData.value = result
    }
}