package com.freedasd.fuel_calculator.domain.consumption.mappers

interface ConsInputDomainToDataMapper<T> {

    fun map(currentMileage: Float, previousMileage: Float, filledFuel: Float) : T
}