package com.freed_asd.fuel_calculator.data.consumption

interface ConsInputData {

    fun consumption() : Float

    class Base(
        private val currentMileage: Float,
        private val previousMileage: Float,
        private val filledFuel: Float
    ): ConsInputData {
        override fun consumption(): Float {
            return (filledFuel / (currentMileage - previousMileage)) * 100
        }
    }
}