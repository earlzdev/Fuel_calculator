package com.FreedAsd.fuel_calculator.data.max_distance

import com.FreedAsd.fuel_calculator.data.max_distance.mappers.InputDataToDomainMapper

interface DistanceInputData {

    fun <T> map(mapper: InputDataToDomainMapper<T>): T

    data class Base(
        private val fuelConsumption: Float,
        private val amountOfFuel: Int,
        private val fuelPrice: Float
    ) : DistanceInputData {
        override fun <T> map(mapper: InputDataToDomainMapper<T>) =
            mapper.map(fuelConsumption, amountOfFuel, fuelPrice)
    }
}