package com.FreedAsd.fuel_calculator.sl

import androidx.lifecycle.ViewModel

interface BaseModule<V: ViewModel> {

    fun viewModel() : V
}