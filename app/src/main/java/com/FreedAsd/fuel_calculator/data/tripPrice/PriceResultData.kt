package com.FreedAsd.fuel_calculator.data.tripPrice

data class PriceResultData (
    val distance: Float,
    val needFuel: Float,
    val generalTripPrice: Float,
    val everyoneTripPrice: Float,
    val passengers: Float
)