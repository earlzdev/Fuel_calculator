package com.FreedAsd.fuel_calculator.domain.max_distance

interface DistanceInputDomain {

    fun <T> map(mapper: Mapper<T>) : T

    data class Base(
        private val fuelConsumption: Float,
        private val amountOfFuel: Float,
        private val fuelPrice: Float
    ) : DistanceInputDomain {
        override fun <T> map(mapper: Mapper<T>) =
            mapper.map(fuelConsumption, amountOfFuel, fuelPrice)
    }

    interface Mapper<T> {
        fun map(fuelConsumption: Float, amountOfFuel: Float, fuelPrice: Float) : T
    }
}