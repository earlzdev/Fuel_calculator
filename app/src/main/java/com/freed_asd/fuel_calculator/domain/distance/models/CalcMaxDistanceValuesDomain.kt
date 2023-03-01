package com.freed_asd.fuel_calculator.domain.distance.models

import com.freed_asd.fuel_calculator.domain.distance.mappers.InputDomainToDataMapper

interface CalcMaxDistanceValuesDomain {

    fun <T> map(mapper: InputDomainToDataMapper<T>) : T

    data class Base(
        private val fuelConsumption: Float,
        private val amountOfFuel: Float,
        private val fuelPrice: Float
    ) : CalcMaxDistanceValuesDomain {
        override fun <T> map(mapper: InputDomainToDataMapper<T>) =
            mapper.map(fuelConsumption, amountOfFuel, fuelPrice)
    }
}