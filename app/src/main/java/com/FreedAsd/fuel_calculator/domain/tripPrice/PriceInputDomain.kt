package com.freedasd.fuel_calculator.domain.tripPrice

data class PriceInputDomain (
    val averageConsumption: Float,
    val distance: Float,
    var fuelPrice: Float = 1f,
    var passengersCount: Float = 1f
)