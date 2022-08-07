package com.freed_asd.fuel_calculator.domain.consumption.mappers

interface ConsResultDomainToUiMapper <T> {

    fun map(consumption: Float) : T
}