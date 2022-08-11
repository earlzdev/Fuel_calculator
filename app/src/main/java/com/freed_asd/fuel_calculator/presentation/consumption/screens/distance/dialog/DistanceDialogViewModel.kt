package com.freed_asd.fuel_calculator.presentation.consumption.screens.distance.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi

class DistanceDialogViewModel : BaseViewModel<Repository, ConsResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<ConsResultUi>) {
        liveData.observe(owner, observer)
    }

    fun provideResult(result: ConsResultUi) {
        liveData.value = result
    }
}