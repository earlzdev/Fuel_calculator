package com.freed_asd.fuel_calculator.presentation.price

import com.freed_asd.fuel_calculator.presentation.price.mappers.PriceInputUiToDomainMapper

interface PriceInputUi {

    fun <T> map(mapper: PriceInputUiToDomainMapper<T>) : T

    class Base(
        private val averageConsumption: Float,
        private val distance: Float,
        private var fuelPrice: Float = 1f,
        private var passengersCount: Float = 1f
    ) : PriceInputUi {
        override fun <T> map(mapper: PriceInputUiToDomainMapper<T>) =
            mapper.map(averageConsumption, distance, fuelPrice, passengersCount)
    }
}
