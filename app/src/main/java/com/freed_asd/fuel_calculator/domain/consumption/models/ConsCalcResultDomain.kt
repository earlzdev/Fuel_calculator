package com.freed_asd.fuel_calculator.domain.consumption.models

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsResultDomainToUiMapper

interface ConsCalcResultDomain {

    fun <T> map(mapper: ConsResultDomainToUiMapper<T>) : T

    class Base(
        private val consumption: Float
    ) : ConsCalcResultDomain {
        override fun <T> map(mapper: ConsResultDomainToUiMapper<T>) =
            mapper.map(consumption)
    }
}