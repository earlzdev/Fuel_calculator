package com.freed_asd.fuel_calculator.presentation.distance.screens.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freed_asd.fuel_calculator.presentation.core.BaseViewModel
import com.freed_asd.fuel_calculator.presentation.distance.DistanceResultUi

class DialogFragmentViewModel : BaseViewModel<DistanceResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<DistanceResultUi>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun provideResult(result: DistanceResultUi) {
        liveData.value = result
    }
}