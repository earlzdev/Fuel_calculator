package com.freed_asd.fuel_calculator.presentation.consumption.mappers

interface ConsInputUiToDomainMapper <T> {

<<<<<<< HEAD
    fun map(distance: Float, filledFuel: Float) : T
=======
    fun map(currentMileage: Float, previousMileage: Float, filledFuel: Float) : T
>>>>>>> master
}