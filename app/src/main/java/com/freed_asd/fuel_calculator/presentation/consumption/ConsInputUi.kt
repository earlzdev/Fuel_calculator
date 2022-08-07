package com.freed_asd.fuel_calculator.presentation.consumption

import com.freed_asd.fuel_calculator.presentation.consumption.mappers.ConsInputUiToDomainMapper

interface ConsInputUi {

    fun <T> map(mapper: ConsInputUiToDomainMapper<T>) : T

    class Base(
        private val currentMileage: Float,
        private val previousMileage: Float,
        private val filledFuel: Float
    ) : ConsInputUi {
        override fun <T> map(mapper: ConsInputUiToDomainMapper<T>) =
            mapper.map(currentMileage, previousMileage, filledFuel)
    }
}