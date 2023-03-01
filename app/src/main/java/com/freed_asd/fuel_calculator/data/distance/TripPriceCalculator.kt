package com.freed_asd.fuel_calculator.data.distance

interface TripPriceCalculator {
    fun calculate(amountOfFuel: Float, fuelPrice: Float) : Float
    class Base : TripPriceCalculator {
        override fun calculate(amountOfFuel: Float, fuelPrice: Float) =
            amountOfFuel * fuelPrice
    }
}