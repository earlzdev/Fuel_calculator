package com.freed_asd.fuel_calculator.domain.consumption.models

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsInputDomainToDataMapper

interface ConsCalcValuesDomain {

    fun <T> map(mapper: ConsInputDomainToDataMapper<T>) : T

    class Base(
        private val distance: Float,
        private val filledFuel: Float
    ) : ConsCalcValuesDomain {
        override fun <T> map(mapper: ConsInputDomainToDataMapper<T>) =
            mapper.map(distance, filledFuel)
    }
}