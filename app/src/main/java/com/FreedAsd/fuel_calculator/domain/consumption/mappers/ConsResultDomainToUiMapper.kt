package com.freedasd.fuel_calculator.domain.consumption.mappers

interface ConsResultDomainToUiMapper <T> {

    fun map(consumption: Float) : T
}