package com.freed_asd.fuel_calculator.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.freed_asd.fuel_calculator.data.Repository

abstract class BaseViewModel<T:Repository, V> : ViewModel() {

    protected val liveData = MutableLiveData<V>()

    open fun observe(owner: LifecycleOwner, observer: Observer<V>) {
        liveData.observe(owner, observer)
    }
}