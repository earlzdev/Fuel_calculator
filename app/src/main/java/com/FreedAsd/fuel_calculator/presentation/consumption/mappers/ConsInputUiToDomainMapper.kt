package com.freedasd.fuel_calculator.presentation.consumption.mappers

interface ConsInputUiToDomainMapper <T> {

    fun map(currentMileage: Float, previousMileage: Float, filledFuel: Float) : T
}