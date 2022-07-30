package com.FreedAsd.fuel_calculator.domain.calc_fuel_price

data class PriceInputDomain (
    val averageConsumption: Float,
    val distance: Float,
    var fuelPrice: Float = 1f,
    var passengersCount: Float = 1f
)