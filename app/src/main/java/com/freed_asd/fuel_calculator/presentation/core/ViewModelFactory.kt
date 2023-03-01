package com.freed_asd.fuel_calculator.presentation.core

import androidx.lifecycle.ViewModelProvider

interface ViewModelFactory {

    fun provide(): ViewModelProvider.Factory
}