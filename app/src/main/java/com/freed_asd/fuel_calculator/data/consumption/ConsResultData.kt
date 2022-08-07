package com.freed_asd.fuel_calculator.data.consumption

import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsResultDataToDomainMapper

interface ConsResultData {

    fun <T> map(mapper: ConsResultDataToDomainMapper<T>) : T

    class Base(
        private val consumption: Float
    ) : ConsResultData {
        override fun <T> map(mapper: ConsResultDataToDomainMapper<T>) =
           mapper.map(consumption)
    }
}