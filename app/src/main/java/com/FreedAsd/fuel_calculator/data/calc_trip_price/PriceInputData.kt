package com.FreedAsd.fuel_calculator.data.calc_trip_price

data class PriceInputData (
    val averageConsumption: Float,
    val distance: Float,
    var fuelPrice: Float = 1f,
    var passengersCount: Float = 1f
)