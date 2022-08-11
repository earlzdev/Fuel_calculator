package com.freed_asd.fuel_calculator.presentation.consumption

import com.freed_asd.fuel_calculator.presentation.consumption.mappers.ConsInputUiToDomainMapper

interface ConsInputUi {

    fun <T> map(mapper: ConsInputUiToDomainMapper<T>) : T

    class Base(
        private val distance: Float,
        private val filledFuel: Float
    ) : ConsInputUi {
        override fun <T> map(mapper: ConsInputUiToDomainMapper<T>) =
            mapper.map(distance, filledFuel)
    }
}