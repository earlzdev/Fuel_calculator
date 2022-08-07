package com.freedasd.fuel_calculator.presentation.distance.screens.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.freedasd.fuel_calculator.core.BaseViewModel
import com.freedasd.fuel_calculator.data.Repository
import com.freedasd.fuel_calculator.presentation.distance.DistanceResultUi

class DialogFragmentViewModel : BaseViewModel<Repository, DistanceResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<DistanceResultUi>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun provideResult(result: DistanceResultUi) {
        liveData.value = result
    }

}