package com.FreedAsd.fuel_calculator.presentation.calc_trip_price

data class PriceInputDataUi(
    val averageConsumption: Float,
    val distance: Float,
    var fuelPrice: Float = 1f,
    var passengersCount: Float = 1f
)
