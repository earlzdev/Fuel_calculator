package com.freed_asd.fuel_calculator.domain.consumption.mappers

interface ConsInputDomainToDataMapper<T> {

    fun map(distance: Float, filledFuel: Float) : T
}