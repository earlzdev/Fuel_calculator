package com.freed_asd.fuel_calculator.core

import androidx.lifecycle.ViewModelProvider

interface ViewModelFactory {

    fun provide(): ViewModelProvider.Factory
}