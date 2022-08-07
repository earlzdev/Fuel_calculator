package com.freedasd.fuel_calculator.presentation.consumption.screens.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freedasd.fuel_calculator.core.BaseViewModel
import com.freedasd.fuel_calculator.data.Repository
import com.freedasd.fuel_calculator.presentation.consumption.ConsResultUi

class ConsDialogViewModel: BaseViewModel<Repository, ConsResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<ConsResultUi>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun provideResult(result: ConsResultUi) {
        liveData.value = result
    }
}