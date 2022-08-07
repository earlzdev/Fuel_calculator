package com.FreedAsd.fuel_calculator.presentation.tripPrice

data class PriceInputDataUi(
    val averageConsumption: Float,
    val distance: Float,
    var fuelPrice: Float = 1f,
    var passengersCount: Float = 1f
)
