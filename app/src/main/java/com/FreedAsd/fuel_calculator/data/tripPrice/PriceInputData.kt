package com.FreedAsd.fuel_calculator.data.tripPrice

data class PriceInputData (
    val averageConsumption: Float,
    val distance: Float,
    var fuelPrice: Float = 1f,
    var passengersCount: Float = 1f
)