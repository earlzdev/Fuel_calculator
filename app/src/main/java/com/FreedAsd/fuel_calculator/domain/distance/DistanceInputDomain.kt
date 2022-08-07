package com.freedasd.fuel_calculator.domain.distance

import com.freedasd.fuel_calculator.domain.distance.mappers.InputDomainToDataMapper

interface DistanceInputDomain {

    fun <T> map(mapper: InputDomainToDataMapper<T>) : T

    data class Base(
        private val fuelConsumption: Float,
        private val amountOfFuel: Float,
        private val fuelPrice: Float
    ) : DistanceInputDomain {
        override fun <T> map(mapper: InputDomainToDataMapper<T>) =
            mapper.map(fuelConsumption, amountOfFuel, fuelPrice)
    }
}