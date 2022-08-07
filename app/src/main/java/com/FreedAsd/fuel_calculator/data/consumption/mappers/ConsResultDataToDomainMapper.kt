package com.freedasd.fuel_calculator.data.consumption.mappers

interface ConsResultDataToDomainMapper<T> {

    fun map(consumption: Float) : T
}