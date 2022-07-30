package com.FreedAsd.fuel_calculator.domain.calc_fuel_price

data class PriceResultDomain (
    val distance: Float,
    val needFuel: Float,
    val generalTripPrice: Float,
    val everyoneTripPrice: Float,
    val passengers: Float
)