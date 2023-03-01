package com.freed_asd.fuel_calculator.data.distance.models

import com.freed_asd.fuel_calculator.data.distance.MaxDistanceCalculator
import com.freed_asd.fuel_calculator.data.distance.TripPriceCalculator

interface CalcMaxDistanceValuesData {

    fun calculateMaxDistance(mapper: MaxDistanceCalculator) : Float

    fun calculateTripPrice(mapper: TripPriceCalculator) : Float

    data class Base(
        private val fuelConsumption: Float,
        private val amountOfFuel: Float,
        private val fuelPrice: Float
    ) : CalcMaxDistanceValuesData {

        override fun calculateMaxDistance(mapper: MaxDistanceCalculator) : Float {
            return mapper.calculate(fuelConsumption, amountOfFuel)
        }

        override fun calculateTripPrice(mapper: TripPriceCalculator): Float {
            return mapper.calculate(amountOfFuel, fuelPrice)
        }
    }
}
