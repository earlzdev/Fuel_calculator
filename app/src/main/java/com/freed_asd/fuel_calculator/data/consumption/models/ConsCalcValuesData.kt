package com.freed_asd.fuel_calculator.data.consumption.models

interface ConsCalcValuesData {

    fun calculateConsumption() : Float

    class Base(
        private val distance: Float,
        private val filledFuel: Float
    ): ConsCalcValuesData {

        override fun calculateConsumption(): Float {
            return (filledFuel / (distance)) * 100
        }
    }
}