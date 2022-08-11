package com.freed_asd.fuel_calculator.data.consumption

interface ConsInputData {

    fun consumption() : Float

    class Base(
        private val distance: Float,
        private val filledFuel: Float
    ): ConsInputData {
        override fun consumption(): Float {
            return (filledFuel / (distance)) * 100
        }
    }
}