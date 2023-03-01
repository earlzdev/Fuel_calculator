package com.freed_asd.fuel_calculator.presentation.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<V> : ViewModel() {

    protected val liveData = MutableLiveData<V>()

    open fun observe(owner: LifecycleOwner, observer: Observer<V>) {
        liveData.observe(owner, observer)
    }
}