package com.freed_asd.fuel_calculator.presentation.distance.screens.dialog

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.freed_asd.fuel_calculator.core.BaseViewModel
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freed_asd.fuel_calculator.presentation.distance.DistanceResultUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DialogFragmentViewModel(
    private val distanceInteractor: DistanceInteractor
) : BaseViewModel<Repository, DistanceResultUi>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<DistanceResultUi>) {
        super.observe(owner, observer)
        liveData.observe(owner, observer)
    }

    fun provideResult(result: DistanceResultUi) {
        liveData.value = result
    }

    fun insertIntoDb() {

        val value = liveData.value
        val distance = value?.distance()
        val price = value?.price()
        if (distance == null || price == null) return
        viewModelScope.launch(Dispatchers.IO) {
            distanceInteractor.insertIntoDb(distance, price)
        }
    }
}