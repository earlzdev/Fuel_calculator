package com.freed_asd.fuel_calculator.presentation.consumption.mappers

interface ConsInputUiToDomainMapper <T> {

    fun map(distance: Float, filledFuel: Float) : T
}