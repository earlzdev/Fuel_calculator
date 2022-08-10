package com.freed_asd.fuel_calculator.domain.consumption

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsInputDomainToDataMapper

interface ConsInputDomain {

    fun <T> map(mapper: ConsInputDomainToDataMapper<T>) : T

    class Base(
        private val distance: Float,
        private val filledFuel: Float
    ) : ConsInputDomain {
        override fun <T> map(mapper: ConsInputDomainToDataMapper<T>) =
            mapper.map(distance, filledFuel)
    }
}