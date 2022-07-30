package com.FreedAsd.fuel_calculator.presentation.calc_trip_price

data class PriceResultUi(
    val distance: Float,
    val needFuel: Float,
    val generalTripPrice: Float,
    val everyoneTripPrice: Float,
    val passengers: Float
)
