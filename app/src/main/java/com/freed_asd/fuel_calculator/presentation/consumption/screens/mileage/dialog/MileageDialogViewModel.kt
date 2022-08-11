package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi

class MileageDialogViewModel: BaseViewModel<Repository, ConsResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<ConsResultUi>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun provideResult(result: ConsResultUi) {
        liveData.value = result
    }
}