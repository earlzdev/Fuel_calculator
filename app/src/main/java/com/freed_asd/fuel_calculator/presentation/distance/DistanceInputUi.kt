package com.freed_asd.fuel_calculator.presentation.distance

import com.freed_asd.fuel_calculator.presentation.distance.mappers.InputUiToDomainMapper

interface DistanceInputUi {

    fun <T> map(mapper: InputUiToDomainMapper<T>) : T

    class Base(
        private val fuelConsumption: Float,
        private val amountOfFuel: Float,
        private val fuelPrice: Float
    ) : DistanceInputUi {
        override fun <T> map(mapper: InputUiToDomainMapper<T>) =
            mapper.map(fuelConsumption, amountOfFuel, fuelPrice)
    }
}