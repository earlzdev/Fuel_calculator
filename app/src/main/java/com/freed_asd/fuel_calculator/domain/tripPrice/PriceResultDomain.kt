package com.freed_asd.fuel_calculator.domain.tripPrice

data class PriceResultDomain (
    val distance: Float,
    val needFuel: Float,
    val generalTripPrice: Float,
    val everyoneTripPrice: Float,
    val passengers: Float
)