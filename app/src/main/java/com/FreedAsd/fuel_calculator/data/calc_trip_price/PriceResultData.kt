package com.FreedAsd.fuel_calculator.data.calc_trip_price

data class PriceResultData (
    val distance: Float,
    val needFuel: Float,
    val generalTripPrice: Float,
    val everyoneTripPrice: Float,
    val passengers: Float
)