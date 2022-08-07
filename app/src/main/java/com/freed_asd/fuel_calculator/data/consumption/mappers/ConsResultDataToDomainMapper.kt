package com.freed_asd.fuel_calculator.data.consumption.mappers

interface ConsResultDataToDomainMapper<T> {

    fun map(consumption: Float) : T
}