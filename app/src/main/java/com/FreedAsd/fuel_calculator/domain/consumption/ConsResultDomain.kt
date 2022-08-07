package com.freedasd.fuel_calculator.domain.consumption

import com.freedasd.fuel_calculator.domain.consumption.mappers.ConsResultDomainToUiMapper

interface ConsResultDomain {

    fun <T> map(mapper: ConsResultDomainToUiMapper<T>) : T

    class Base(
        private val consumption: Float
    ) : ConsResultDomain {
        override fun <T> map(mapper: ConsResultDomainToUiMapper<T>) =
            mapper.map(consumption)
    }
}