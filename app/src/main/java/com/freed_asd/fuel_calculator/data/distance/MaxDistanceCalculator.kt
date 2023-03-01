package com.freed_asd.fuel_calculator.data.distance

interface MaxDistanceCalculator {
    fun calculate(fuelConsumption: Float, amountOfFuel: Float) : Float
    class Base : MaxDistanceCalculator {
        override fun calculate(fuelConsumption: Float, amountOfFuel: Float) =
            (100 / fuelConsumption) * amountOfFuel
    }
}