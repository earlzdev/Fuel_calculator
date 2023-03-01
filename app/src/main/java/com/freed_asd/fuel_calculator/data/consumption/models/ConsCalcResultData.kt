package com.freed_asd.fuel_calculator.data.consumption.models

import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsResultDataToDomainMapper

interface ConsCalcResultData {

    fun <T> map(mapper: ConsResultDataToDomainMapper<T>) : T

    class Base(
        private val consumption: Float
    ) : ConsCalcResultData {

        override fun <T> map(mapper: ConsResultDataToDomainMapper<T>) =
           mapper.map(consumption)
    }
}