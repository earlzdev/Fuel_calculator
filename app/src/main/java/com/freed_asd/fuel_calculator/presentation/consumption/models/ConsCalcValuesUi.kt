package com.freed_asd.fuel_calculator.presentation.consumption.models

import com.freed_asd.fuel_calculator.presentation.consumption.mappers.ConsInputUiToDomainMapper

interface ConsCalcValuesUi {

    fun <T> map(mapper: ConsInputUiToDomainMapper<T>) : T

    class Base(
        private val distance: Float,
        private val filledFuel: Float
    ) : ConsCalcValuesUi {
        override fun <T> map(mapper: ConsInputUiToDomainMapper<T>) =
            mapper.map(distance, filledFuel)
    }
}