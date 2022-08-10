package com.freed_asd.fuel_calculator.presentation.distance.mappers

interface InputUiToDomainMapper<T> {

    fun map(fuelConsumption: Float, amountOfFuel: Float, float: Float) : T
}